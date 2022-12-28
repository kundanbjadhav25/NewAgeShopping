package com.userdata;

import java.util.Scanner;

import com.cartdetails.AddProductsToCart;
import com.cartdetails.DisplayList;
import com.cartdetails.FinalCartData;
import com.useronly.VerifyExistingUserCredentials;

public class ExistingUser {
	static Scanner scanner = new Scanner(System.in);

	public String getProgramForExistingUser() {
		VerifyExistingUserCredentials verifyExistingUserCredentials = new VerifyExistingUserCredentials();
		DisplayList displayList = new DisplayList();
		AddProductsToCart addProductsToCart = new AddProductsToCart();
		FinalCartData finalCartData = new FinalCartData();
		try {
			verifyExistingUserCredentials.checkUserLogin();
			displayList.displayProductList();
			System.out.println("");
			System.out.println("Enter the cout of product you wish to buy");
			System.out.println("");
			System.out.println("Enter here >> ");
			int count = scanner.nextInt();
			for (int i = 1; i <= count; i++) {
				addProductsToCart.storeProductInCart();
			}
			System.out.println("");
			System.out.println("Enter '0' to CheckOut Window");
			System.out.println("");
			System.out.println("Enter here >> ");
			int gotocart = scanner.nextInt();
			if (gotocart == 0) {
				finalCartData.getCheckoutDetails();
			} else {
				System.err.println("Invalid option selected");
			}
			System.out.println("------>>Thank You for Shopping<<-------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "You can close window";
	}

	public static void main(String[] args) {
		ExistingUser existingUser = new ExistingUser();
		existingUser.getProgramForExistingUser();
	}
}
