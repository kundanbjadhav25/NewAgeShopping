package com.userdata;

import java.util.Scanner;

import com.cartdetails.DisplayList;

public class CasualUser {

	public String getProgramforCasulUser() {
		DisplayList displayList = new DisplayList();
		NewUser newUser = new NewUser();
		
		try {
			displayList.displayProductList();
			System.out.println("");
			System.out.println("Please Register yourself to buy any product");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter '0' for registration window");
			int selection = scanner.nextInt();
			if(selection==0) {
				newUser.getProgramForNewUser();
			}else {
				System.out.println("Invalid Input");
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		CasualUser casualUser = new CasualUser();
		casualUser.getProgramforCasulUser();
	}
}
