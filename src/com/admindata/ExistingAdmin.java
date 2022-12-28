package com.admindata;

import java.util.Scanner;

import com.adminonly.RegisteredUserData;
import com.adminonly.TotalProductQuantity;
import com.adminonly.UserPurchaseHistory;
import com.adminonly.VerifyAdminLoginCredential;

public class ExistingAdmin {
	
	Scanner scanner = new Scanner(System.in);
	public String getExistingAdminLogin() {
		VerifyAdminLoginCredential verifyAdminLoginCredential = new VerifyAdminLoginCredential();
		RegisteredUserData registeredUserData = new RegisteredUserData();
		UserPurchaseHistory userPurchaseHistory = new UserPurchaseHistory();
		TotalProductQuantity totalProductQuantity = new TotalProductQuantity();
		try {
			verifyAdminLoginCredential.checkAdminUsername();
			System.out.println("Please Select form below Options");
			System.out.println("Enter - 1 > Get Registered User Data ");
			System.out.println("Enter - 2 > Get User Purchase History ");
			System.out.println("Enter - 3 > Get Sold Quantity of Product");
			System.out.println("");
			System.out.println("Enter here >> ");
			int option = scanner.nextInt();
			switch(option) {
			case 1:
				registeredUserData.getAllRegisteredUserData();
				break;
			case 2:
				userPurchaseHistory.getUserPurchaseHistory();
				break;
			case 3:
				totalProductQuantity.getTotalProductQuantity();
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return "";
	}
	public static void main(String[] args) {
		ExistingAdmin existingAdmin = new ExistingAdmin();
		existingAdmin.getExistingAdminLogin();
	}
}
