package com.cartdetails;

import java.sql.Connection;
import java.sql.DriverManager;
// This class provides method to establish connection with MYSQL
public class ConnectionClass {
	//use this method to establish connection with MYSQL
	public Connection getJDBCConnection() {
		Connection connection = null; //creating reference variable to use Connection Interface
		try {
		//Loading the driver class into JDBC
		Class.forName("com.mysql.jdbc.Driver");
		//establishing connection with host database
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;	// return type of method
	}
}
