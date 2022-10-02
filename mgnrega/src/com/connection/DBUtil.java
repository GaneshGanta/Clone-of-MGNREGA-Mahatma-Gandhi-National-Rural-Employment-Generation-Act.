package com.connection;


import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	
	public static Connection provideConnection() {
		
		Connection conn=null;
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.getMessage(); 
		}
		
		String url="jdbc:mysql://localhost:3306/mgnrega"; 
		
		try {
			conn= DriverManager.getConnection(url,"root","Masai");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}
	
	
	
	
	
	
}

