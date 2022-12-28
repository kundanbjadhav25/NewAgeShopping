package com.useronly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.cartdetails.ConnectionClass;


public class UserLoginCredentials {
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	static Scanner scanner = new Scanner(System.in);
	//use this method to create new registered User username and password
	public String storeUserLoginCredential() throws SQLException {
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("----->>CREATE LOGIN ID AND PASSWORD<<-----");
		System.out.println("------------------------------------------");
		System.out.println("Create the Login Id");
		String userUserName = scanner.next();
		System.out.println("Create the Password");
		String userPassword = scanner.next();
		try {
			//write query into prepare statement
			String insertQuery = "insert into userlogincredential(User_Username, User_Password)values(?,?);";
			preparedStatement=connection.prepareStatement(insertQuery);
			//store user id password details into table						
			preparedStatement.setString(1, userUserName);
			preparedStatement.setString(2, userPassword);	
			preparedStatement.executeUpdate();
			System.out.println("The UserId and Password stored successfully");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) throws SQLException {
		UserLoginCredentials userLoginCredentials = new UserLoginCredentials();
		userLoginCredentials.storeUserLoginCredential();
	}
}
