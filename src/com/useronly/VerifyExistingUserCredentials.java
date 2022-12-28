package com.useronly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.cartdetails.ConnectionClass;

public class VerifyExistingUserCredentials {
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	static Scanner scanner = new Scanner(System.in);
	static ResultSet resultSet = null;

	// use this method to verify the user's username and password
	public String checkUserLogin() {
		try {
			System.out.println("");
			System.out.println("------------------------------------------");
			System.out.println("--------->>VERIFICATION OF USER<<---------");
			System.out.println("------------------------------------------");
			System.out.println("Please enter your Username");
			String userName = scanner.next();
			// using prepare statement sending the query details
			// check if username is already present in database or not
			preparedStatement = connection
					.prepareStatement("select * from userlogincredential where User_Username='" + userName + "'");
			// using result set fetch the table data
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Username is Correct");
				try {
					System.out.println("Please Enter Password");
					String userPassword = scanner.next();
					// using prepare statement sending the query details
					// check if password is already present in database or not
					preparedStatement = connection.prepareStatement(
							"select * from userlogincredential where User_Password='" + userPassword + "'");
					// using result set fetch the table data
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						System.out.println("Password is Correct");
						System.out.println("User Login is successful");
						// Program for admin commands
					} else {
						System.err.println("Incorrect User Password");
						System.out.println("Please try again using correct User Password");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("Incorrect User Username");
				System.out.println("Please try again using correct User Username");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	public static void main(String[] args) {
		VerifyExistingUserCredentials verifyExistingUserCredentials = new VerifyExistingUserCredentials();
		verifyExistingUserCredentials.checkUserLogin();
	}
}
