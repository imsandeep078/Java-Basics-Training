package com.bankingsystem.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.FundTransfer;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.repository.UsersRepository;

public class FundTransferByUser {

	static Map<UserCredentials, AccountDetails> holders = UsersRepository.registeredAccountHolders();

	public static boolean isAccountNumPresent(long accountNum) {
		Iterator<AccountDetails> accountList = holders.values().iterator();
		while (accountList.hasNext()) {
			AccountDetails accountDrtails = (AccountDetails) accountList.next();
			if (accountDrtails.getAccountNumber() == accountNum) {
				return true;
			}
		}
		return false;
	}

	public static double currentAmount(String userName, String userPassword) {
		Iterator<Map.Entry<UserCredentials, AccountDetails>> credentialsAndAccount = holders.entrySet().iterator();
		while (credentialsAndAccount.hasNext()) {
			Map.Entry<UserCredentials, AccountDetails> entry = (Map.Entry<UserCredentials, AccountDetails>) credentialsAndAccount
					.next();
			if (entry.getKey().getUserName().equals(userName)
					&& entry.getKey().getUserPassword().equals(userPassword)) {
				return entry.getValue().getAmount();
			}
		}
		return 0;
	}

	public static FundTransfer fundTransfer(String userName, String userPassword, long accountNum, double transferAmount) {
		Iterator<Map.Entry<UserCredentials, AccountDetails>> credentialsAndAccount = holders.entrySet().iterator();
		while (credentialsAndAccount.hasNext()) {
			Map.Entry<UserCredentials, AccountDetails> entry = (Map.Entry<UserCredentials, AccountDetails>) credentialsAndAccount
					.next();
			if (entry.getKey().getUserName().equals(userName)
					&& entry.getKey().getUserPassword().equals(userPassword)) {
				long fromAccount = entry.getValue().getAccountNumber();
				Iterator<AccountDetails> accountList = holders.values().iterator();
				while (accountList.hasNext()) {
					AccountDetails accountDetails = (AccountDetails) accountList.next();
					if (accountDetails.getAccountNumber() == accountNum) {
						double fromAccountAmount = entry.getValue().getAmount();
						double updatedFromAccountAmount = fromAccountAmount - transferAmount;
						entry.getValue().setAmount(updatedFromAccountAmount);
						
						double toAccountAmount = accountDetails.getAmount();
						double updatedToAccountAmount = toAccountAmount + transferAmount;
						accountDetails.setAmount(updatedToAccountAmount);
						
						FundTransfer fundTransfer = new FundTransfer();
						fundTransfer.setFromAccount(fromAccount);
						fundTransfer.setToAccount(accountNum);
						fundTransfer.setAmount(transferAmount);
						fundTransfer.setTransferedDate(LocalDate.now());
						
						if (UsersRepository.fundsTransfer(fundTransfer)) {
							return fundTransfer;
						}
					}
				}
				return null;
			}

		}
		return null;
	}

}
