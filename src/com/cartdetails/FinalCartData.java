package com.cartdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//provides the check out option of cart to user
public class FinalCartData {

	// creating static variables to perform operations in whole class
		static ConnectionClass connectionClass = new ConnectionClass();
		static Connection connection = connectionClass.getJDBCConnection();
		static PreparedStatement preparedStatement = null;
		static ResultSet resultSet = null;
		static Scanner scanner = new Scanner(System.in);
		
		public String getCheckoutDetails() {
			System.out.println("Enter User Id for checkout window");
			String userId = scanner.next();
			int Total_Cart_Amount=0;
			int SR_No = 0;
			try {
				String writeQuery1 = "select * from productlist inner join cart on productlist.Product_Id= cart.Product_Id and User_ID='"+ userId +"'";
				preparedStatement=connection.prepareStatement(writeQuery1);
				resultSet=preparedStatement.executeQuery();
				System.out.println("");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("---------------------------------------------------------->>CART DETAILS<<------------------------------------------------------");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Sr_No \tUser_ID\t    Product_Id \tProduct_Name \tProduct_Price \t Product_Quantity \tTotal_Amount \t Product_Description");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
				while(resultSet.next()) {
					SR_No = SR_No+1;
					System.out.println(SR_No +")"+"\t"+resultSet.getString(6)+"\t"+resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t\t\t"+resultSet.getInt(9)+"\t\t"+resultSet.getInt(10)+"\t\t"+resultSet.getString(4));
					System.out.println("----------------------------------------------------------------------------------------------------------------------------");
				}				
				String writeQuery = "select sum(Amount) from cart where User_ID='"+ userId +"'";
				preparedStatement=connection.prepareStatement(writeQuery);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					System.out.println("");
					Total_Cart_Amount = resultSet.getInt(1);
					System.out.println("Final Payable Amount is >> "+Total_Cart_Amount);
				}				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return "Your Order Placed Succcessfully.....";
		}
		public static void main(String[] args) {
			FinalCartData finalCartData = new FinalCartData();
			finalCartData.getCheckoutDetails();
		}
}
