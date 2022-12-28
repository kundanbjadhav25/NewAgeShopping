package com.cartdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//admin can store/update/delete products data from here
public class ProductList {
	// creating static variables to perform operations in whole class
		static ConnectionClass connectionClass = new ConnectionClass();
		static Connection connection = connectionClass.getJDBCConnection();
		static PreparedStatement preparedStatement = null;
		static Scanner scanner = new Scanner(System.in); // to get dynamic inputs
		
	//use this method to store products into batabase
	public void storeProductRecord() throws SQLException {		 
			System.out.println("Enter the count of products ");
			int count = scanner.nextInt();
			try {
				//write query into prepare statement
				String insertQuery = "insert into productlist(Product_Name, Product_Price, Product_Description)values(?,?,?);";
				preparedStatement=connection.prepareStatement(insertQuery);
				//use loop to store multiple records into table
				for(int i = 1 ; i<=count; i++) {
				//store actual product details into table			
				System.out.println("Enter the Product Name");
				String productName = scanner.next();
				System.out.println("Enter the Product Price");
				String productPrice = scanner.next();
				System.out.println("Enter the Product Description");
				String productDescription = scanner.nextLine();
				preparedStatement.setString(1, productName);
				preparedStatement.setString(2, productPrice);
				preparedStatement.setString(3, productDescription);
				//adds the prepare statement commands into batch
				preparedStatement.addBatch();	
				preparedStatement.executeUpdate();
				//meaningful message
				System.out.println("The "+ productName +  " details stored into Product List Successfully...");				
				}							
			} catch (Exception e) {
				e.printStackTrace();
			}finally {

				connection.close();
				preparedStatement.close();			
			}
		}
	}
