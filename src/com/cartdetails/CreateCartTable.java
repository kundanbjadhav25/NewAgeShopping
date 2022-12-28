package com.cartdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateCartTable {

	// creating static variables to perform operations in whole class
		static ConnectionClass connectionClass = new ConnectionClass();
		static Connection connection = connectionClass.getJDBCConnection();
		static PreparedStatement preparedStatement = null;

		// creating cart table to store all user purchase details
		public String createTableCart() {
			try {
				String writeQuery = "create table cart(SR_No int primary key auto_increment, User_ID varchar(255), Product_Id int,Product_Price int ,Product_Quantity int,Amount int );";
				preparedStatement=connection.prepareStatement(writeQuery);
				int i =preparedStatement.executeUpdate();
				System.out.println("Cart Table created successfully..." + i);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}
		public static void main(String[] args) {
			CreateCartTable createCartTable = new CreateCartTable();
			createCartTable.createTableCart();
			
	}
}
