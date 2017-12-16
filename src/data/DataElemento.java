package data;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.KeyStore.ProtectionParameter;
import java.sql.*;
import entity.*;
import util.AppDataException;

public class DataElemento {
	
	public Elemento getById(int idElem) throws Exception{
		Elemento elemento= null;		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from elemento where nombre=?");
			stmt.setInt(1, idElem);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					elemento =new Elemento();
					elemento.setTipoElem(new TipoElemento());					
					elemento.setId(rs.getInt("idE"));
					elemento.setNombre(rs.getString("nombre"));
					elemento.setDescrip(rs.getString("descripcion"));
				//	elemento.getTipoElem().setDescripcion(rs.getString("descripcion"));
				//	elemento.getTipoElem().setIdT(rs.getInt("idT"));						
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar elemento de la BD");
			
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 	
		return elemento;
	}
	

	public void add(Elemento elem) throws Exception {
		PreparedStatement stmt=null;
		try{			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into elemento (idT, nombre, descripcion) values (?,?,?)");
			stmt.setInt(1, elem.getTipoElem().getIdT());
			stmt.setString(2, elem.getNombre());
			stmt.setString(3, elem.getDescrip());
			stmt.executeUpdate();	
		
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible agregar elemento a la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 		
	}
	
	public void delete(Elemento elem) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from elemento where idE=?");
			stmt.setInt(1, elem.getId());
			stmt.executeUpdate();		
		
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible borrar elemento en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
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
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar elemento de la BD");
			
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
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
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar los elementos de la BD");
			
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
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
			
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible actualizar elemento en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 	
	}
	
	public ArrayList<Elemento> getDisponibles(Reserva r, int tipo) throws Exception{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		try {
			String cant = r.getCantHoras()+":00:00";
			System.out.println(r.getFecha());
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.idE, e.nombre, e.descripcion from elemento e inner join tipoelemento te on e.idT=te.idT where te.idT=? ");
			stmt.setInt(1, tipo);			
			//stmt.setDate(2, r.getFecha());	
							
			rs=stmt.executeQuery();		
			if(rs!=null){
				while(rs.next()){
					Elemento elem=new Elemento();
					elem.setId(rs.getInt("e.idE"));
					elem.setNombre(rs.getString("e.nombre"));
					elem.setDescrip(rs.getString("e.descripcion"));
					elementos.add(elem);
				}
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar elementos de la BD");
		
		}finally{ 
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {			
				e.printStackTrace();
			}		
		}
		return elementos;		
	}
	
	public ArrayList<Elemento> getByTipo(int t) throws Exception{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elementos= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from elemento where idT=?");
			stmt.setInt(1, t);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Elemento elem=new Elemento();
					elem.setId(rs.getInt("idE"));
					elem.setNombre(rs.getString("nombre"));
					elem.setDescrip(rs.getString("descripcion"));
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
			throw e;
		}	
		System.out.println("Devolviendo elementos desde capa datos");
		return elementos;		
	}	
	
}
