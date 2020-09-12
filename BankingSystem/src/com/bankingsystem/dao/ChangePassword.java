package com.bankingsystem.dao;

import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.repository.UsersRepository;

public class ChangePassword {
	
	public static boolean changedPassword(String userName, String userPassword, String newPassword) {
		Map<UserCredentials, AccountDetails> holders = UsersRepository.registeredAccountHolders();
		Iterator<UserCredentials> credentials = holders.keySet().iterator();
		while (credentials.hasNext()) {
			UserCredentials userCredentials = (UserCredentials) credentials.next();
			if(userCredentials.getUserName().equals(userName) && userCredentials.getUserPassword().equals(userPassword) && userCredentials.getUserRole().equals("user")) {
				userCredentials.setUserPassword(newPassword);
				return true;
			}			
		}
		return false;	
	}

}
