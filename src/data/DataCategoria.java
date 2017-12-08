package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Categoria;
import util.AppDataException;

public class DataCategoria {
	
	public ArrayList<Categoria> getAll() throws Exception{		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Categoria> cats= new ArrayList<Categoria>();
		try{
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from categoria");
			if(rs!=null){
				while(rs.next()){
					Categoria c=new Categoria();
					c.setId(rs.getInt("idC"));
					c.setDescripcion(rs.getString("nivel"));
					cats.add(c);
				}
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar las categorias de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return cats;
	}
	
	public Categoria getById(int id) throws Exception{
		Categoria c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"SELECT * from Categoria where idC=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					c=new Categoria();
					c.setDescripcion(rs.getString("nivel"));
					c.setId(rs.getInt("idC"));
			}
		}catch (SQLException | AppDataException e) {
			throw new AppDataException(e,"No es posible recuperar categoria del usuario de la BD");
			
		}finally{
			try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
		} 
		return c;
	}
}
