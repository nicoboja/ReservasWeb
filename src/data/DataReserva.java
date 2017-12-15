package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Elemento;
import entity.Reserva;
import util.AppDataException;

public class DataReserva {
	
	public void add(Reserva r) throws Exception {
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into reserva (fecha, detalle, idElemento, hora, cantHoras, idPersona, estado) values (?,?,?,?,?,?,?)");
			stmt.setDate(1, r.getFecha());
			stmt.setString(2, r.getDetalle());
			stmt.setInt(3, r.getElem().getId());
			stmt.setTime(4, r.getHora());
			stmt.setInt(5, r.getCantHoras());
			stmt.setInt(6, r.getPer().getId());
			stmt.setString(7, r.getEstado());
			stmt.executeUpdate();
		
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible agregar reserva a la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 	
	}

	public ArrayList<Reserva> getById(int idPers) throws Exception {
		System.out.println("dataReserva!");
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Reserva r=null;
		ArrayList<Reserva> revs= new ArrayList<Reserva>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select * from reserva r inner join elemento e on r.idElemento = e.idE where idPersona=? and r.fecha >= CURDATE(); ");
			stmt.setInt(1, idPers);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					r=new Reserva();
					r.setElem(new Elemento());
					r.setId(rs.getInt("idR"));
					r.setFecha(rs.getDate("fecha"));
					r.setHora(rs.getTime("hora"));
					r.setDetalle(rs.getString("detalle"));
					r.setCantHoras(rs.getInt("cantHoras"));
					r.setEstado(rs.getString("estado"));
					r.getElem().setNombre(rs.getString("nombre"));
					r.getElem().setDescrip(rs.getString("descripcion"));
					revs.add(r);
				}
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar Reservas de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return revs;
	}

	public void cancelRes(Reserva r) throws Exception{
		PreparedStatement stmt=null;
		try{
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"update reserva set estado='Cancelado' where idR=?;");
			stmt.setInt(1, r.getId());			
			stmt.executeUpdate();		
			
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible cancelar reserva en la BD");
			
		}finally{
			try{
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 	
	}
	
	public int getTotalByTipo(Reserva r) throws Exception{
		int cant=0;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select count(*) cant from reserva r inner join elemento e on r.idElemento=e.idE inner join tipoelemento t on e.idT=t.idT"
					+ "where t.idT=? and fecha > CURRENT_TIMESTAMP() AND r.estado='Pendiente' AND r.idPersona = ?;");
			stmt.setInt(1, r.getElem().getTipoElem().getIdT());
			stmt.setInt(2, r.getPer().getId());
			rs = stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					cant = rs.getInt("cant");
				}	
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar reservas de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return cant;
	}
	
	public Date getFecActual() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		java.sql.Date fecActual = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("SELECT CURDATE();");					
			if(rs!=null){
				while(rs.next()){
					fecActual=(rs.getDate("CURDATE()"));
				}
			}				
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar fecha de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 		
		return fecActual;
	}
	
	public Reserva getById(Reserva r) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Reserva> getByFecTipo(Date fecha, int t) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		Reserva r=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from reserva r inner join elemento e r.idElemento=e.idE  "
					+ "where fecha=? and e.idT=? and estado='Pendiente'");			
			stmt.setDate(1, fecha);
			stmt.setInt(2, t);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){					
					r=new Reserva();				
					r.setElem(new Elemento());
					r.setId(rs.getInt("idR"));
					r.setFecha(rs.getDate("fecha"));
					r.setCantHoras(rs.getInt("cantHoras"));
					r.setHora(rs.getTime("hora"));
					r.getElem().setId(rs.getInt("idElemento"));
					res.add(r);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("enviando array getByFecha");
		return res;
	}


}
