package com.adminonly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.cartdetails.ConnectionClass;

//create login credential for admin only
public class AdminLoginCredentials {
		
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	static Scanner scanner = new Scanner(System.in);

	//use this method to create admin username and password
	public String storeAdminLoginCredential() {
		System.out.println("");
		System.out.println("------------>>FOR ADMIN ONLY<<------------");
		System.out.println("----->>CREATE LOGIN ID AND PASSWORD<<-----");
		System.out.println("------------------------------------------");
		System.out.println("Create the Login Id");
		String adminUserName = scanner.next();
		System.out.println("Create the Password");
		String adminPassword = scanner.next();
		try {
			//write query into prepare statement
			String insertQuery = "insert into adminlogincredential(Admin_ID, Admin_Password)values(?,?);";
			preparedStatement=connection.prepareStatement(insertQuery);
			//store admin id password details into table						
			preparedStatement.setString(1, adminUserName);
			preparedStatement.setString(2, adminPassword);	
			preparedStatement.executeUpdate();
			System.out.println("The Admin Id and Password stored successfully");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		AdminLoginCredentials adminLoginCredentials = new AdminLoginCredentials();
		adminLoginCredentials.storeAdminLoginCredential();
	}
}
