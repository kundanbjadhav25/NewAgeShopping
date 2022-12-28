package com.cartdetails;
//class provides the user purchase details 

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserTable {
	// creating static variables to perform operations in whole class
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;

	// creating user table to store all user purchase details
	public String createUserTable() {
		try {
			String writeQuery = "create table user (Product_Id int primary key not null auto_increment ,Product_Name    varchar(255),Product_Price int,Product_Description varchar(255),Product_Quantity int,Amount int,User_ID varchar(255),User_Password varchar(255));";
			preparedStatement=connection.prepareStatement(writeQuery);
			int s = preparedStatement.executeUpdate();
			System.out.println("table created successfully " + s);


		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
	public static void main(String[] args) {
		UserTable userTable = new UserTable();
		userTable.createUserTable();
	}
}
