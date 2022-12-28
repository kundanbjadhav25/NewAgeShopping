package com.cartdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// provides the method which adds product into cart 
public class AddProductsToCart {

	// creating static variables to perform operations in whole class
		static ConnectionClass connectionClass = new ConnectionClass();
		static Connection connection = connectionClass.getJDBCConnection();
		static PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		static Scanner scanner = new Scanner(System.in);
		// storing purchase details in cart
		public String storeProductInCart() {
			System.out.println("Enter User Id");
			String userId = scanner.next();		
			System.out.println("Enter Product Id to Buy");
			int productId = scanner.nextInt();
			System.out.println("Enter no of Product Quantity to Buy");
			int productQuantity = scanner.nextInt();
			int Product_Price=0;
			int Amount = 0;
			try {
				String writeQuery = "select * from productlist where Product_Id="+productId;
				preparedStatement=connection.prepareStatement(writeQuery);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					Product_Price=resultSet.getInt(3);						
				}
				String writeQuery1 = "insert into cart(User_ID, Product_Id ,Product_Price ,Product_Quantity,Amount)values(?,?,?,?,?);";
				preparedStatement=connection.prepareStatement(writeQuery1);
				preparedStatement.setString(1, userId);
				preparedStatement.setInt(2,productId );
				preparedStatement.setInt(3,Product_Price );
				preparedStatement.setInt(4, productQuantity);
				Amount=Product_Price*productQuantity;
				preparedStatement.setInt(5,Amount );
				preparedStatement.executeUpdate();
				System.out.println("Products added to cart successfully...");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "";
		}
		public static void main(String[] args) {
			AddProductsToCart addProductsToCart = new AddProductsToCart();
			addProductsToCart.storeProductInCart();
		}
}
