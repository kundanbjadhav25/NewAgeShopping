package com.admindata;

import java.util.Scanner;
import com.adminonly.AdminLoginCredentials;

public class AdminData {
	static Scanner scanner = new Scanner(System.in);

	public String getAdminControlProgam() {
		ExistingAdmin existingAdmin = new ExistingAdmin();
		AdminLoginCredentials adminLoginCredentials = new AdminLoginCredentials();
		System.out.println("Please Select form below Options");
		System.out.println("Enter - 1 > Existing Admin (have Admin ID and Password) ");
		System.out.println("Enter - 2 > New Admin (Create Admin ID and Password) ");
		System.out.println("");
		System.out.println("Enter here >> ");		
		int option = scanner.nextInt();

		switch(option) {
		
		case 1:		
			existingAdmin.getExistingAdminLogin();
			break;
		case 2:		
			adminLoginCredentials.storeAdminLoginCredential();
			existingAdmin.getExistingAdminLogin();
			break;
		}
		return "";
	}
	public static void main(String[] args) {
		AdminData adminData = new AdminData();
		adminData.getAdminControlProgam();
	}
}
