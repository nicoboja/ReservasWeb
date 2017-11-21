package data;
import java.sql.*;

import util.AppDataException;


public class FactoryConexion {
	
	private String driver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String hostM="127.0.0.1";
	private String port="3306";
	private String user="root";
	private String password="root";
	private String db="reserva";
	
	private static FactoryConexion instancia;
		
	private FactoryConexion(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static FactoryConexion getInstancia(){
		if (FactoryConexion.instancia == null){		
			FactoryConexion.instancia=new FactoryConexion();
		}
		return FactoryConexion.instancia;
		
	}
	
	private Connection conn;
	private int cantConn=0;
	public Connection getConn() throws SQLException,AppDataException{
		try {
			if(conn==null || conn.isClosed()){	
				conn = DriverManager.getConnection(
			        "jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+password);
			}
		} catch (SQLException e) {
			try {
				if(conn==null || conn.isClosed()){	
					conn = DriverManager.getConnection(
				        "jdbc:mysql://"+hostM+":"+port+"/"+db+"?user="+user+"&password="+password);
					
				}
			}catch (SQLException ex){
			throw new AppDataException(ex, "Error al conectar a la base de datos");
			}
		}
		cantConn++;
		return conn;
	}
	
	public void releaseConn() throws SQLException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	

}
