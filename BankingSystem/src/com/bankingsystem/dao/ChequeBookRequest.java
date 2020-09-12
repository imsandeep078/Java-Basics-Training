package com.bankingsystem.dao;

import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.repository.UsersRepository;

public class ChequeBookRequest {

	static Map<UserCredentials, AccountDetails> holders = UsersRepository.registeredAccountHolders();
	static Map<Long, String> chequeBook = UsersRepository.chequeBookList();

	public static String requestChequeBook(String userName, String userPassword, String requestChequeBook) {
		Iterator<Map.Entry<UserCredentials, AccountDetails>> credentialsAndAccount = holders.entrySet().iterator();
		while (credentialsAndAccount.hasNext()) {
			Map.Entry<UserCredentials, AccountDetails> entry = (Map.Entry<UserCredentials, AccountDetails>) credentialsAndAccount
					.next();
			if (entry.getKey().getUserName().equals(userName)
					&& entry.getKey().getUserPassword().equals(userPassword)) {
				long accountNum = entry.getValue().getAccountNumber();
				if (chequeBook.containsKey(accountNum)) {
					String status = chequeBook.get(accountNum);
					if (status.equals("requested")) {
						return "You already requested..";
					} else if (status.equals("approved")) {
						return "You cheque Book request is approved";
					} else {
						return "Something went wrong...";
					}
				} else {
					if (UsersRepository.chequeBook(accountNum, requestChequeBook)) {
						return "You successfully requested for Cheque Book";
					}
				}

			}
		}
		return "Something went wrong...Try Again!!";
	}

}
