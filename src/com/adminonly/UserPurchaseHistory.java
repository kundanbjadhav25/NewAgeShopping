package com.adminonly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cartdetails.ConnectionClass;

public class UserPurchaseHistory {
	static ConnectionClass connectionClass = new ConnectionClass();
	static Connection connection = connectionClass.getJDBCConnection();
	static PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	static Scanner scanner = new Scanner(System.in);
	public String getUserPurchaseHistory() {
		int Total_Cart_Amount= 0;
		System.out.println("Get User Purchase History");
		System.out.println("");
		System.out.println("Enter the Name of User");
		String username = scanner.next();
		try {
			String writequery="select * from cart where User_ID='"+username+"'";
			preparedStatement=connection.prepareStatement(writequery);
			resultSet=preparedStatement.executeQuery();
			System.out.println("");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------->>CART DETAILS<<------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("SR_No\t User_ID\tProduct_Id\tProduct_Price(MRP)\tProduct_Quantity\tAmount(Rupees) ");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {				
				System.out.println(resultSet.getInt(1)+"\t "+resultSet.getString(2)+"\t\t   "+resultSet.getInt(3)+"\t\t  "+resultSet.getInt(4)+"\t\t\t  "+resultSet.getInt(5)+"\t\t\t"+resultSet.getInt(6));
				System.out.println("----------------------------------------------------------------------------------------------------------------------------");
			}	
			String writeQuery = "select sum(Amount) from cart where User_ID='"+ username +"'";
			preparedStatement=connection.prepareStatement(writeQuery);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("");
				Total_Cart_Amount = resultSet.getInt(1);
				System.out.println("Total Purchase Done by "+ username + "  is >> "+Total_Cart_Amount + " Rupees ");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}return "";	
	}
	public static void main(String[] args) {
		UserPurchaseHistory userPurchaseHistory = new UserPurchaseHistory();
		userPurchaseHistory.getUserPurchaseHistory();
	}
}
