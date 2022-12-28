package com.useronly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.cartdetails.ConnectionClass;

public class StoreUserDetails {
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	static Scanner scanner = new Scanner(System.in);

	//use this method to store user details into table
	public String storeRegistrationDetails() throws SQLException {
		System.out.println("");
		System.out.println("------->>ENTER YOUR DETAILS<<-------");
		System.out.println("-------------------------------------");
		System.out.println("Enter First Name");
		String userFirstName = scanner.next();
		System.out.println("Enter Last Name");
		String userLastName = scanner.next();
		System.out.println("Enter Mobile Number");
		String userMobileNumber = scanner.next();
		System.out.println("Enter Valid Email id");
		String userEmailid = scanner.next();
		System.out.println("Enter City Name");
		String userCityName = scanner.next();
		System.out.println("Enter State Name");
		String userStateName = scanner.next();
		System.out.println("Enter City Pincode Number");
		String userCityPincode = scanner.next();
		
		try {
			preparedStatement = connection.prepareStatement("insert into userdetails( First_Name, Last_Name, Mobile_Number, Email, City_Name, State, Pincode, Country)values(?,?,?,?,?,?,?,?);");
			preparedStatement.setString(1, userFirstName);
			preparedStatement.setString(2, userLastName);
			preparedStatement.setString(3, userMobileNumber);
			preparedStatement.setString(4, userEmailid);
			preparedStatement.setString(5, userCityName);
			preparedStatement.setString(6, userStateName);
			preparedStatement.setString(7, userCityPincode);
			preparedStatement.setString(8, "India");
			//executing the query
			int i=preparedStatement.executeUpdate();
			System.out.println("user registration successful..." + i);
			
		} catch (Exception e) {
			e.printStackTrace();
		}return "";
	}
	public static void main(String[] args) throws SQLException {
		StoreUserDetails storeUserDetails = new StoreUserDetails();
		storeUserDetails.storeRegistrationDetails();
	}
}
