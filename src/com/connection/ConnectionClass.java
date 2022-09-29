package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	
	
	public  Connection establishConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/ganesh";
		
			try {
				
				 con = DriverManager.getConnection(url, "root", "Masai");
				
				 
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
			return con;
		

	}
	

}
