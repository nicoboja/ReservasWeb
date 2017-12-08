package data;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;
import entity.*;
import util.AppDataException;

public class DataElemento {

	public void add(Elemento elem) throws Exception {
		PreparedStatement stmt=null;
		try{			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into elemento (idT, nombre, descripcion) values (?,?,?)");
			stmt.setInt(1, elem.getTipoElem().getIdT());
			stmt.setString(2, elem.getNombre());
			stmt.setString(3, elem.getDescrip());
			stmt.executeUpdate();	
			
		}catch (SQLException e) {
				throw new AppDataException(e,"No es posible agregar un elemento en la BD");	
			
		}catch (AppDataException e){
			throw e;
		}
		finally{
			FactoryConexion.getInstancia().releaseConn();
		}			
	}
	
	public void delete(Elemento elem) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from elemento where idE=?");
			stmt.setInt(1, elem.getId());
			stmt.executeUpdate();		
		
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible eliminar el elemento en la BD");
	
		}catch (AppDataException e){
			throw e;
	
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	
	public Elemento getByNombre(Elemento elem) throws Exception{
		Elemento elemento= null;		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.idE, e.`nombre`, e.`descripcion`, t.idT, t.descripcion from elemento e "
					+ "inner join tipoelemento t  on e.`idT` = t.idT where nombre=?");
			stmt.setString(1, elem.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					elemento =new Elemento();
					elemento.setTipoElem(new TipoElemento());					
					elemento.setId(rs.getInt("idE"));
					elemento.setNombre(rs.getString("nombre"));
					elemento.setDescrip(rs.getString("descripcion"));
					elemento.getTipoElem().setDescripcion(rs.getString("descripcion"));
					elemento.getTipoElem().setIdT(rs.getInt("idT"));				
					
			}
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar el elemento de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return elemento;
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
					elem.getTipoElem().setCantMax(rs.getInt("t.maxPend"));						
					elementos.add(elem);
				}
			}
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar elementos de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		
		} catch (SQLException e) {
			throw e;
		}		
		return elementos;		
	}	

	public void update(Elemento elem) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update elemento set nombre=?, descripcion=? where idE=?;");
			stmt.setString(1, elem.getNombre());
			stmt.setString(2, elem.getDescrip());			
			stmt.setInt(3, elem.getId());
			stmt.executeUpdate();		
			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible actualizar elemento en la BD");
	
		}catch (AppDataException e){
			throw e;
			
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
}