package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.TipoElemento;
import util.AppDataException;

public class DataTipoElemento {
	
	public void add(TipoElemento te) throws Exception {
		PreparedStatement stmt=null;
		try{			
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tipoelemento (descripcion, tmax) values (?,?)");
			stmt.setString(1, te.getDescripcion());
			stmt.setInt(2, te.getCantMax());
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible agregar tipo elemento en la BD");	
		
		}catch (AppDataException e){
			throw e;
	
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}			
	}	

	public void delete(TipoElemento te) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from tipoelemento where idT=?");
			stmt.setInt(1, te.getIdT());
			stmt.executeUpdate();	
			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible eliminar el tipo de elemento de la BD");
	
		}catch (AppDataException e){
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public TipoElemento getByNombre(TipoElemento te) throws Exception{
		
		TipoElemento tipoElem=new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from tipoelemento where descripcion=?");
			stmt.setString(1, te.getDescripcion());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					tipoElem.setIdT(rs.getInt("idT"));
					tipoElem.setDescripcion(rs.getString("descripcion"));
					tipoElem.setCantMax(rs.getInt("tmax"));
					tipoElem.setDiasMaxAnt(rs.getInt("diasant"));
			}			
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar el tipo de elemento de la BD");
	
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
		return tipoElem;
	}
	
	public TipoElemento getById(int idTE) throws Exception{
		
		TipoElemento tipoElem=new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from tipoelemento where idT=?");
			stmt.setInt(1, idTE);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					tipoElem.setIdT(rs.getInt("idT"));
					tipoElem.setDescripcion(rs.getString("descripcion"));
					tipoElem.setCantMax(rs.getInt("tmax"));
					tipoElem.setDiasMaxAnt(rs.getInt("diasant"));
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
		return tipoElem;
	}
			
	public void update(TipoElemento te) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update tipoelemento set descripcion=?,  diasant=?, tmax=? where idT=?");
			stmt.setString(1, te.getDescripcion());
			stmt.setInt(2, te.getDiasMaxAnt());
			stmt.setInt(3, te.getCantMax());
			stmt.setInt(4, te.getIdT());
			stmt.executeUpdate();					
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible modificar el tipo de elemento en la BD");
	
		}catch (AppDataException e){
			throw e;
		}finally{
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public ArrayList<TipoElemento> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipoelementos= new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tipoElem=new TipoElemento();
					tipoElem.setIdT(rs.getInt("idT"));
					tipoElem.setDescripcion(rs.getString("descripcion"));
					tipoElem.setCantMax(rs.getInt("maxPend"));
					tipoElem.setDiasMaxAnt(rs.getInt("diasant"));
					tipoelementos.add(tipoElem);
				}
			}
		}catch (SQLException e) {
			throw new AppDataException(e,"No es posible recuperar el elemento de la BD");
	
		}catch (AppDataException e){
			throw e;
		
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return tipoelementos;		
	}	

}