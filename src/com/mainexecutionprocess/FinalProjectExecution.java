package com.mainexecutionprocess;

import java.util.Scanner;

import com.admindata.AdminData;
import com.admindata.ExistingAdmin;
import com.userdata.CasualUser;
import com.userdata.ExistingUser;
import com.userdata.NewUser;

public class FinalProjectExecution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CasualUser casualUser = new CasualUser();
		NewUser newUser = new NewUser();
		ExistingUser existingUser = new ExistingUser();
		AdminData adminData = new AdminData();
		System.out.println("");
		System.out.println("-----------------------------------------------");
		System.out.println("------->>WELCOME TO NEW AGE SHOPPING <<--------");
		System.out.println("-----------------------------------------------");
		System.out.println("----->>SELECT ANY ONE OPTION TO CONTINUE<<-----");
		System.out.println("-----------------------------------------------");
		System.out.println("Option '1' [ Continue to Product List without Login ] ");
		System.out.println("Option '2' [ Create New Account ] ");
		System.out.println("Option '3' [ Existing User (already have username and password) ] ");
		System.out.println("Option '4' [ Admin Login Window ] ");
		System.out.println("");
		System.out.println("Enter your selection here >> ");
		int option = scanner.nextInt();
		switch(option) {
		case 1:
			casualUser.getProgramforCasulUser();
			break;
		case 2:
			newUser.getProgramForNewUser();
			break;
		case 3:
			existingUser.getProgramForExistingUser();
			break;
		case 4:
			adminData.getAdminControlProgam();
			break;
		}		
	}
}
