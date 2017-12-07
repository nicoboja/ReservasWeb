package data;


import java.sql.*;
import java.util.ArrayList;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import entity.Persona;
import entity.TipoElemento;
import util.AppDataException;



public class DatosTipoElemento
{
	
	public ArrayList<TipoElemento> buscarTodo(Persona pers) throws Exception,SQLException
	{
		Statement stm=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> listadotipoelemento= new ArrayList<TipoElemento>();
		
		if(!((pers.getCategoria()).equals("Online"))){
			try 
			{
				stm = FactoryConexion.getInstancia().getConn().createStatement();
				rs = stm.executeQuery("select * from tipoelemento");
				if(rs!=null){
					while(rs.next()){
						TipoElemento tipoele=new TipoElemento();
						tipoele.setId(rs.getInt("id"));
						tipoele.setNombre(rs.getString("nombre"));
						tipoele.setCantMax(rs.getInt("cant_max"));
						tipoele.setEncargado(rs.getBoolean("reservaEncargado"));
						tipoele.setLimiteHoras(rs.getInt("limiteHoras"));
						tipoele.setCantMax(rs.getInt("cantMaxDiasAnticipacion"));
						listadotipoelemento.add(tipoele);
						}
				}
			} catch (SQLException exc) {
				throw new AppDataException(exc,"No es posible buscar un tipo de elemento en la base de datos");
			}catch (Exception e){
				throw e;
			} 
		}
		else{
			try 
			{
				pstm = FactoryConexion.getInstancia().getConn().prepareStatement("select * from tipoelemento where reservaEncargado=b'0'");
//				pstm.(1, false);
				rs = pstm.executeQuery();
				if(rs!=null){
					while(rs.next()){
						TipoElemento tipoele=new TipoElemento();
						tipoele.setId(rs.getInt("id"));
						tipoele.setNombre(rs.getString("nombre"));
						tipoele.setCantMax(rs.getInt("cantMaxRes"));
						tipoele.setEncargado(rs.getBoolean("reservaEncargado"));
						tipoele.setLimiteHoras(rs.getInt("limiteHoras"));
						tipoele.setDiasMax(rs.getInt("cantMaxDiasAnticipacion"));
						listadotipoelemento.add(tipoele);
						}
				}
			} catch (SQLException exc) {
				throw new AppDataException(exc,"No es posible buscar un tipo de elemento en la base de datos");
			}catch (Exception e) 
			{
				throw e;
			}
		}
		try {
			if(rs!=null) rs.close();
			if(pstm!=null) pstm.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (Exception e) {
			
			throw e;
		}
		
		return listadotipoelemento;
		
	}

	public ArrayList<TipoElemento> devolverTodoTipoElemento() throws Exception,SQLException
	{
		Statement stm=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> listadotipoelemento= new ArrayList<TipoElemento>();
		try 
		{
			stm = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stm.executeQuery("select * from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento tipoele=new TipoElemento();
					tipoele.setId(rs.getInt("id"));
					tipoele.setNombre(rs.getString("nombre"));
					tipoele.setCantMax(rs.getInt("cantMaxRes"));
					tipoele.setEncargado(rs.getBoolean("reservaEncargado"));
					tipoele.setLimiteHoras(rs.getInt("limiteHoras"));
					tipoele.setDiasMax(rs.getInt("cantMaxDiasAnticipacion"));
					listadotipoelemento.add(tipoele);
					}
			}
		} catch (SQLException exc) {
			throw new AppDataException(exc,"No es posible buscar un tipo de elemento en la base de datos");
		}catch (Exception e){
			throw e;
		}
		
		try {
			if(stm!=null){
				stm.close();
				FactoryConexion.getInstancia().releaseConn();
			}
			
		} catch (Exception e) {
			throw e;
		}
		return listadotipoelemento;	
		
	}
	
	
	public void agregarTipoElemento (TipoElemento tipoele) throws Exception,SQLException
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = FactoryConexion.getInstancia().getConn().prepareStatement(
					"INSERT INTO tipoelemento(nombre,cantMaxRes,reservaEncargado,limiteHoras,cantMaxDiasAnticipacion) VALUES (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, tipoele.getNombre());
			pstm.setInt(2, tipoele.getCantMax());
			pstm.setBoolean(3,tipoele.getEncargado());
			pstm.setInt(4, tipoele.getLimiteHoras());
			pstm.setInt(5, tipoele.getDiasMax());
			pstm.executeUpdate();
			rs=pstm.getGeneratedKeys();
			if(rs!=null && rs.next()){
				tipoele.setId(rs.getInt(1));
			}
		} catch (SQLException exc) {
			throw new AppDataException(exc,"No es posible agregar un tipo de elemento en la base de datos");
		} catch (Exception e) {
			throw e;
		}
		
		try {
			if(rs!=null)rs.close();
			if(pstm!=null)pstm.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void eliminarTipoElemento(TipoElemento tipoele) throws Exception,SQLException
	{
		PreparedStatement pstm = null;
		
		
		try {
			pstm = FactoryConexion.getInstancia().getConn().prepareStatement(
					"DELETE FROM tipoelemento WHERE id=?");
			pstm.setInt(1, tipoele.getId());
			pstm.executeUpdate();
		}catch (MySQLIntegrityConstraintViolationException exc) {
			throw new AppDataException(exc,"Imposible eliminar, Tipo de Elemento tiene Elementos dependientes");
		}  
		catch (SQLException exc) {
			throw new AppDataException(exc,"Imposible eliminar, Tipo de Elemento tiene Elementos dependientes");
		} 
			catch(Exception e){
				throw e;		
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException exc) {
			throw new AppDataException(exc,"Error de conexi�n");			
		}
		catch (Exception exc) {
			throw exc;			
		}
	}
	
	public void modificarTipoElemento(TipoElemento tipoele) throws Exception,SQLException
	{
		PreparedStatement pstm = null;
		
		
		try {
			pstm = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE tipoelemento SET nombre=?,cantMaxRes=?,reservaEncargado=?,limiteHoras=?,cantMaxDiasAnticipacion=?  WHERE id=?");
			pstm.setString(1, tipoele.getNombre());
			pstm.setInt(2, tipoele.getCantMax());
			pstm.setBoolean(3,tipoele.getEncargado());
			pstm.setInt(4, tipoele.getLimiteHoras());
			pstm.setInt(5, tipoele.getDiasMax());
			pstm.setInt(6, tipoele.getId());
			pstm.executeUpdate();
		} catch (SQLException exc) {
			throw new AppDataException(exc,"No es posible modificar un tipo de elemento en la base de datos");	
		} catch (Exception e) {
			throw e;
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}	
		
	}
	
	public TipoElemento buscarTipoElemento(TipoElemento tipoele) throws Exception,SQLException
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = FactoryConexion.getInstancia().getConn().prepareStatement("Select * from tipoelemento where id=?");
			pstm.setInt(1, tipoele.getId());
			rs=pstm.executeQuery();
			if(rs!=null){
				while(rs.next())
					{
					tipoele.setId(rs.getInt("id"));
					tipoele.setNombre(rs.getString("nombre"));
					tipoele.setCantMax(rs.getInt("cantMaxRes"));
					tipoele.setEncargado(rs.getBoolean("reservaEncargado"));
					tipoele.setLimiteHoras(rs.getInt("limiteHoras"));
					tipoele.setDiasMax(rs.getInt("cantMaxDiasAnticipacion"));
					}
						}
		} catch (SQLException exc) {
			throw new AppDataException(exc,"No es posible buscar un tipo de elemento en la base de datos");	
		}catch (Exception e) {
			throw e;
		}
		
		try {
			if(pstm!=null)pstm.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (Exception e) {
			throw e;
		}	
		
		
		return tipoele;
	}
	
}

