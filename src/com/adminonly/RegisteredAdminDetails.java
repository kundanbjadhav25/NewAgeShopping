package com.adminonly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cartdetails.ConnectionClass;

public class RegisteredAdminDetails {

	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	public String getRegisteredAdminDetails() {
		
		try {
			String writequery="select * from adminlogincredential;";
			preparedStatement=connection.prepareStatement(writequery);
			resultSet=preparedStatement.executeQuery();
			System.out.println("");
			System.out.println("---------------------------------------------------");
			System.out.println("------------>>REGISTERED ADMIN LIST<<--------------");
			System.out.println("---------------------------------------------------");
			System.out.println("Sr_No\tAdmin_ID\tAdmin_Password");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
				System.out.println("---------------------------------------------------");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		RegisteredAdminDetails registeredAdminDetails = new RegisteredAdminDetails();
		registeredAdminDetails.getRegisteredAdminDetails();
	}

}
