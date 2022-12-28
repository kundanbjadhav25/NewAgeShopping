package com.userdata;

import com.useronly.StoreUserDetails;
import com.useronly.UserLoginCredentials;

public class NewUser {

	public String getProgramForNewUser() {
		StoreUserDetails storeUserDetails = new StoreUserDetails();
		UserLoginCredentials userLoginCredentials = new UserLoginCredentials();
		ExistingUser existingUser = new ExistingUser();
		try {
			storeUserDetails.storeRegistrationDetails();
			userLoginCredentials.storeUserLoginCredential();
			existingUser.getProgramForExistingUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		NewUser newUser = new NewUser();
		newUser.getProgramForNewUser();
	}
}
