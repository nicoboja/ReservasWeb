package data;

import java.util.ArrayList;

import java.sql.*;

import entity.*;
import util.AppDataException;

public class DataPersona {
	
	public void add(Persona p) throws Exception{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into persona(dni, nombre, apellido, habilitado, idC) values (?,?,?,?,?)");
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.setInt(5, p.getCategoria().getId());
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible agregar la persona en la BD");	
		
		}catch (AppDataException e){
		throw e;
		
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public void remove(Persona p) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from persona where idP=?");
			stmt.setInt(1, p.getId());
			stmt.executeUpdate();		

		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible eliminar el elemento en la BD");
	
		}catch (AppDataException e){
			throw e;
	
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public void update(Persona p) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update persona set dni=?,nombre=?, apellido=?,habilitado=?, idC=? where idP=?;");
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.setInt(5, p.getCategoria().getId());
			stmt.setInt(6, p.getId());
			stmt.execute();		
			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible modificar persona en la BD");
	
		}catch (AppDataException e){
			throw e;
			
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}	
	}
	
	public ArrayList<Persona> getAll() throws Exception{	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from persona p inner join categoria c on p.idC=c.idC ORDER BY p.dni ASC");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("idP"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setUss(rs.getString("usuario"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("idC"));
					p.getCategoria().setDescripcion(rs.getString("nivel"));
					pers.add(p);
				}
			}
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar personas de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		
		} catch (SQLException e) {
			throw e;
		}		
		return pers;		
	}
	
	public Persona getByDni(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select p.idP, nombre, apellido, dni, habilitado, p.idC, nivel from persona p inner join categoria c on p.idC=c.idC where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("idP"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("idC"));
					p.getCategoria().setDescripcion(rs.getString("nivel"));
			}
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar personas de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		
		} catch (SQLException e) {
			throw e;
		}
		return p;
	}
	
	public Persona getByUss(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT p.idP, nombre, apellido, dni, habilitado, contra, usuario, p.idC, nivel from persona p inner join categoria c on p.idC=c.idC where usuario=?");
			stmt.setString(1, per.getUss());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("idP"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId(rs.getInt("idC"));
					p.getCategoria().setDescripcion(rs.getString("nivel"));
					p.setPass(rs.getString("contra"));
					p.setUss(rs.getString("usuario"));
			}
			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar personas de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		
		} catch (SQLException e) {
			throw e;
		}
		return p;
	}	

	public Persona getLogedUser(Persona per) throws Exception{
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		System.out.println(per.getUss()+" HOLA "+per.getPass());
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT p.idP, nombre, apellido, dni, habilitado, contra, usuario, p.idC, nivel from persona p inner join categoria c on p.idC=c.idC where usuario=? and contra=?");
			stmt.setString(1, per.getUss());
			stmt.setString(2, per.getPass());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("idP"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.setUss(rs.getString("usuario"));
					p.getCategoria().setId(rs.getInt("idC"));
					p.getCategoria().setDescripcion(rs.getString("nivel"));					
			}			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar personas de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		
		} catch (SQLException e) {
			throw e;
		}
		return p;
	}
}
