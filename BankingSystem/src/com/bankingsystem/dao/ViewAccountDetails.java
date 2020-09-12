package com.bankingsystem.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.repository.UsersRepository;

public class ViewAccountDetails {
	
	public static void viewAccountDetails(String userName, String userPassword) {
		Map<UserCredentials, AccountDetails> details = UsersRepository.registeredAccountHolders();
		Iterator<Map.Entry<UserCredentials, AccountDetails>> credentialsAndAccount = details.entrySet().iterator();
		while (credentialsAndAccount.hasNext()) {
			Map.Entry<UserCredentials, AccountDetails> entry = (Map.Entry<UserCredentials, AccountDetails>) credentialsAndAccount
					.next();
			if(entry.getKey().getUserName().equals(userName) && entry.getKey().getUserPassword().equals(userPassword)) {
				long accountNum = entry.getValue().getAccountNumber();
				String accountType = entry.getValue().getAccountType();
				LocalDate openingDate = entry.getValue().getOpeningDate();
				double amount = entry.getValue().getAmount();				
				System.out.println("\t-------------------ACCOUNT DETAILS--------------------");
				System.out.println("\tAccount No.\tType\t\tCreation Date\tAmount");
				System.out.println("\t" + accountNum + "\t\t" + accountType + "\t\t" + openingDate + "\t" + amount);
				System.out.println("\t------------------------------------------------------");
			}
			
		}
	}

}
