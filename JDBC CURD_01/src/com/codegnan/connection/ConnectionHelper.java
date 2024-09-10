package com.codegnan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/Adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
	}

}
