package com.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	// Method for Connecting database
	public static Connection getConnection()
	{
		Connection connection=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_system","root" ,"root");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
}
