package data;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;
import entity.*;
import util.AppDataException;

public class DataElemento {

	public void add(Elemento e) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try{
			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into elemento (idT, nombre, descripcion) values (?,?,?)");
			stmt.setInt(1, e.getTipoElem().getIdT());
			stmt.setString(2, e.getNombre());
			stmt.setString(3, e.getDescrip());
			stmt.executeUpdate();			
			
		}catch (AppDataException e1){
			throw new AppDataException(e1,"No es posible agregar ese elemento");
		}
		finally{
			FactoryConexion.getInstancia().releaseConn();
		}			
	}
	
	public void delete(Elemento e) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from elemento where idE=?");
			stmt.setInt(1, e.getId());
			stmt.executeUpdate();			
		}catch (AppDataException e1){
			throw new AppDataException(e1,"No se ha podido eliminar ese elemento");
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	
	public Elemento getByNombre(Elemento e) throws Exception{
		Elemento elem= null;
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.idE, e.`nombre`, e.`descripcion`, t.idT, t.descripcion from elemento e inner join tipoelemento t  on e.`idT` = t.idT where nombre=?");
			stmt.setString(1, e.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					elem =new Elemento();
					elem.setTipoElem(new TipoElemento());
					
					elem.setId(rs.getInt("idE"));
					elem.setNombre(rs.getString("nombre"));
					elem.setDescrip(rs.getString("descripcion"));
					elem.getTipoElem().setDescripcion(rs.getString("descripcion"));
					elem.getTipoElem().setIdT(rs.getInt("idT"));
				
					
			}
			
		} catch (Exception e1) {
			throw e1;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e1) {
				throw e1;
			}
		}
		return elem;
	}
	
	public ArrayList<Elemento> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elemento e inner join tipoelemento t on e.idT=t.idT order by t.descripcion");
			if(rs!=null){
				while(rs.next()){
					Elemento elem=new Elemento();
					elem.setTipoElem(new TipoElemento());
					elem.setId(rs.getInt("idE"));
					elem.setNombre(rs.getString("nombre"));
					elem.setDescrip(rs.getString("descripcion"));
					elem.getTipoElem().setIdT(rs.getInt("idT"));
					elem.getTipoElem().setDescripcion(rs.getString("t.descripcion"));
					elem.getTipoElem().setCantMax(rs.getInt("maxPend"));
					
					
					elementos.add(elem);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} 

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return elementos;		
	}	

	public void update(Elemento e) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update elemento set nombre=?, descripcion=? where idE=?;");
			stmt.setString(1, e.getNombre());
			stmt.setString(2, e.getDescrip());
			
			stmt.setInt(3, e.getId());
			stmt.executeUpdate();		
			System.out.println("Se Modifico la Persona con ID= "+e.getId()+" Nombre: "+e.getNombre());
		}catch (AppDataException e1){
			throw new AppDataException(e1,"No se ha podido eliminar ese elemento");
			
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
}
