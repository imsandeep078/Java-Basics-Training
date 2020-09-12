package com.bankingsystem.dao;

import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.repository.UsersRepository;

public class Authentication {
	
	public static String isValid(String userName, String userPassword) {
		Map<UserCredentials, AccountDetails> holders = UsersRepository.registeredAccountHolders();
		Iterator<UserCredentials> credentials = holders.keySet().iterator();
		while (credentials.hasNext()) {
			UserCredentials userCredentials = (UserCredentials) credentials.next();
			if(userCredentials.getUserName().equals(userName) && userCredentials.getUserPassword().equals(userPassword)) {
				return userCredentials.getUserRole();
			}			
		}
		return "Credentials are not VALID!! or User not FOUND!!";	
	}
	
//	public static void sample() {
//		Map<UserCredentials, AccountDetails> holders = UsersRepository.registeredAccountHolders();
//		for (UserCredentials items : holders.keySet()) {
//			System.out.println(items.getUserName());
//			System.out.println(items.getUserPassword());
//			System.out.println(items.getUserRole());
//		}
//		for (AccountDetails items : holders.values()) {
//			System.out.println(items.getAccountNumber());
//			System.out.println(items.getAccountType());
//			System.out.println(items.getAmount());
//			System.out.println(items.getOpeningDate());
//		}
//	}

}
