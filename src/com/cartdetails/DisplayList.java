package com.cartdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// program for display the product list details on console
public class DisplayList {
	// creating static variables to perform operations in whole class
		static ConnectionClass connectionClass = new ConnectionClass();
		static Connection connection = connectionClass.getJDBCConnection();
		static PreparedStatement preparedStatement = null;
		static ResultSet resultSet = null;
	//use this method to display the list
	public ResultSet displayProductList() throws SQLException {				
		try {
			//using prepare statement sending the query details
			preparedStatement = connection.prepareStatement("select * from productlist;");
			//using result set fetch the table data 
			resultSet =preparedStatement.executeQuery(); 
			System.out.println("");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("                      ELECTRONICS ACCESSORIES LIST                                        ");
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("Product_Id \t Product_Name \t Product_Price \t Product_Description");
			System.out.println("---------------------------------------------------------------------------------------");
			//while loop to fetch multiple records
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("Product_Id")+"\t\t"+resultSet.getString("Product_Name")+"\t"+resultSet.getInt("Product_Price")+"\t\t"+resultSet.getString("Product_Description"));
				System.out.println("---------------------------------------------------------------------------------------");
			}
			System.out.println("NOTE:- Use Product Id for adding Products into cart");
			System.out.println("------->>>Please select from above Product list only<<<-------");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
