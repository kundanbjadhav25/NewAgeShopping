package com.adminonly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cartdetails.ConnectionClass;

public class RegisteredUserData {
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public String getAllRegisteredUserData() {
		try {
			String writequery="select * from userdetails;";
			preparedStatement=connection.prepareStatement(writequery);
			resultSet=preparedStatement.executeQuery();
			System.out.println("");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("----------------------->>USER REGISTRATION DATA<<---------------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Sr_No  \tFirst_Name\tLast_Name\tMobile_Number\tEmail\t\t\tCity_Name\tState\t\tPincode\t\tCountry");
			while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+")"+"\t"+ resultSet.getString(2)+"\t\t" + resultSet.getString(3)+"\t\t"+resultSet.getString(4)+"\t" +resultSet.getString(5)+ "\t\t"+resultSet.getString(6)+"\t\t"+resultSet.getString(7)+"\t\t"+resultSet.getString(8)+"\t\t"+resultSet.getString(9));
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		RegisteredUserData registeredUserData  = new RegisteredUserData();
		registeredUserData.getAllRegisteredUserData();
	}
}
