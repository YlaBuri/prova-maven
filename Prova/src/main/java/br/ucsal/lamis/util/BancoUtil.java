package br.ucsal.lamis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ucsal.lamis.model.Usuario;

public class BancoUtil {
	private static Connection connection;

	String driver="org.hsqldb.jdbcDriver";
	String url="jdbc:hsqldb:hsql://localhost/banco";
	String user="SA";
	
	static {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			connection = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/banco", "SA", "");
		} catch (Exception e) {
			System.out.println("erro: "+e );
		}	 	 	
	}

	public static Connection getConnection() { 
		return connection; 
	} 	
	
	
}