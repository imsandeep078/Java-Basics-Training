package com.bankingsystem.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.FundTransfer;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.repository.UsersRepository;

public class BankStatement {
	
	static Map<UserCredentials, AccountDetails> holders = UsersRepository.registeredAccountHolders();
	static List<FundTransfer> userMiniStatementList = new LinkedList<FundTransfer>();
	
	public static List<FundTransfer> miniStatement(String userName, String userPassword) {
		userMiniStatementList.clear();
		Iterator<Map.Entry<UserCredentials, AccountDetails>> credentialsAndAccount = holders.entrySet().iterator();
		while (credentialsAndAccount.hasNext()) {
			Map.Entry<UserCredentials, AccountDetails> entry = (Map.Entry<UserCredentials, AccountDetails>) credentialsAndAccount
					.next();
			if (entry.getKey().getUserName().equals(userName)
					&& entry.getKey().getUserPassword().equals(userPassword)) {
				long accountNum = entry.getValue().getAccountNumber();
				List<FundTransfer> fundTransferStatement = UsersRepository.fundTransfer();
				if(!fundTransferStatement.isEmpty()) {
					Iterator<FundTransfer> fund = fundTransferStatement.iterator();
					while (fund.hasNext()) {
						FundTransfer fundTransfer = (FundTransfer) fund.next();
						if(fundTransfer.getFromAccount() == accountNum || fundTransfer.getToAccount() == accountNum) {
							FundTransfer transfer = new FundTransfer();
							transfer.setFromAccount(fundTransfer.getFromAccount());
							transfer.setToAccount(fundTransfer.getToAccount());
							transfer.setAmount(fundTransfer.getAmount());
							transfer.setTransferedDate(fundTransfer.getTransferedDate());
							userMiniStatementList.add(transfer);
						}
					}
					return userMiniStatementList;
				} else {
					return null;
				}
			}
		}
		return null;		
	}
	
	public static void miniStatementList() {
		if(userMiniStatementList.size() != 0) {
			System.out.println("\t--------------------Mini-Statement----------------");
			System.out.println("\tDEBIT ACCOUNT\tCREDIT ACCOUNT\tAMOUNT\t\tDATE");
			for (FundTransfer fundTransfer : userMiniStatementList) {
				System.out.println("\t"+fundTransfer.getFromAccount()+"\t\t"+fundTransfer.getToAccount()+"\t\t"+fundTransfer.getAmount()+"\t\t"+fundTransfer.getTransferedDate());
			}
			System.out.println("\t--------------------------------------------------");
		} else {
			System.out.println("No transactions happened..");
		}
	}

}
