package com.adminonly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cartdetails.ConnectionClass;

public class TotalProductQuantity {

	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	static ResultSet resultSet = null; 
	static Scanner scanner = new Scanner(System.in);
	
	public String getTotalProductQuantity() {
		System.out.println("Enter the Product Id to check Quantity");
		int productId = scanner.nextInt();
		try {
			String writequery="select sum(Product_Quantity) from cart where Product_Id="+productId;
			preparedStatement=connection.prepareStatement(writequery);
			resultSet=preparedStatement.executeQuery();
			System.out.println("");
			while(resultSet.next()) {
				System.out.println("The total Number of sold products of this Product Id ["+productId+"] is >> "+resultSet.getInt(1) +" nos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		TotalProductQuantity totalProductQuantity = new TotalProductQuantity();
		totalProductQuantity.getTotalProductQuantity();
	}
}
