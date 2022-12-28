package com.adminonly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.cartdetails.ConnectionClass;

public class VerifyAdminLoginCredential {

	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	static Scanner scanner = new Scanner(System.in);
	static ResultSet resultSet = null;

	// use this method to verify the admin login ID and password
	public String checkAdminUsername() {
		System.out.println("");
		System.out.println("------------------------------------------");
		System.out.println("--------->>VERIFICATION OF ADMIN<<--------");
		System.out.println("------------------------------------------");
		System.out.println("Please enter Admin Id");
		String adminId = scanner.next();
		try {
			// using prepare statement sending the query details
			// check if Id is already present in database or not
			preparedStatement = connection.prepareStatement(
					"select * from adminlogincredential where Admin_ID='" + adminId + "'");
			// using result set fetch the table data
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Username is Correct");
				System.out.println("Please Enter Admin Password");
				String adminPassword = scanner.next();
				try {
					// using prepare statement sending the query details
					// check if password is already present in database or not
					preparedStatement = connection.prepareStatement(
							"select * from adminlogincredential where Admin_Password='" + adminPassword + "'");
					// using result set fetch the table data
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						System.out.println("Password is Correct");
						System.out.println("Admin Login is successful");
						// Program for admin commands
					} else {
						System.err.println("Incorrect Admin Password");
						System.out.println("Please try again using correct Admin Password");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("Incorrect Admin Username");
				System.out.println("Please try again using correct Admin Username");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		VerifyAdminLoginCredential verifyAdminLoginCredential = new VerifyAdminLoginCredential();
		verifyAdminLoginCredential.checkAdminUsername();
	}
}
