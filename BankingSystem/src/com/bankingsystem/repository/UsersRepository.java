package com.bankingsystem.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.FundTransfer;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.beans.UserDetails;

public class UsersRepository {

	static Set<UserDetails> registeredUserDetails = new HashSet<UserDetails>();
	static Set<AccountDetails> registeredAccountDetails = new HashSet<AccountDetails>();
	static Map<UserCredentials, UserDetails> credentialsAndDetails = new LinkedHashMap<UserCredentials, UserDetails>();
	static Map<UserCredentials, AccountDetails> credentialsAndAccount = new LinkedHashMap<UserCredentials, AccountDetails>();
	static List<FundTransfer> fundsTransferList = new ArrayList<FundTransfer>();
	static Map<Long, String> chequeBook = new LinkedHashMap<Long, String>();

	static {
// ADMIN CREDENTIALS-->
		UserCredentials credentials = new UserCredentials();
		credentials.setUserName("Sandeep");
		credentials.setUserPassword("sandeep");
		credentials.setUserRole("admin");
		AccountDetails accDetails = new AccountDetails();
		credentialsAndAccount.put(credentials, accDetails);

		/* ----------USER CREDENTIALS, ACCOUNT DETAILS and PERSONAL DETAILS---------- */
		
		// USER 1
		UserCredentials credentials1 = new UserCredentials();
		credentials1.setUserName("sam");
		credentials1.setUserPassword("sam");
		credentials1.setUserRole("user");
		AccountDetails accDetails1 = new AccountDetails();
		accDetails1.setAccountNumber(10000);
		accDetails1.setAccountType("savings");
		accDetails1.setAmount(1000);
		accDetails1.setOpeningDate(LocalDate.of(2020, 10, 20));
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setFirstName("Sandeep");
		userDetails1.setLastName("Tiwari");
		userDetails1.setDateOfBirth(LocalDate.of(1997, 9, 17));
		userDetails1.setPhoneNumber(9582848409l);
		userDetails1.setAdhaarNumber(805987654321l);
		credentialsAndDetails.put(credentials1, userDetails1);
		credentialsAndAccount.put(credentials1, accDetails1);

		// USER 2 -->
		UserCredentials credentials2 = new UserCredentials();
		credentials2.setUserName("don");
		credentials2.setUserPassword("don");
		credentials2.setUserRole("user");
		AccountDetails accDetails2 = new AccountDetails();
		accDetails2.setAccountNumber(20000);
		accDetails2.setAccountType("savings");
		accDetails2.setAmount(2000);
		accDetails2.setOpeningDate(LocalDate.of(2019, 10, 20));
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setFirstName("Deepak");
		userDetails2.setLastName("Tiwari");
		userDetails2.setDateOfBirth(LocalDate.of(1995, 6, 27));
		userDetails2.setPhoneNumber(7503440009l);
		userDetails2.setAdhaarNumber(404030302020l);
		credentialsAndDetails.put(credentials2, userDetails2);
		credentialsAndAccount.put(credentials2, accDetails2);
	}

	public static boolean registeredUserDetails(UserDetails userDetails) {
		try {
			if (registeredUserDetails.isEmpty()) {
				registeredUserDetails.add(userDetails);
				return true;
			} else {
				Iterator<UserDetails> check = registeredUserDetails.iterator();
				while (check.hasNext()) {
					UserDetails details = (UserDetails) check.next();
					if (details.getAdhaarNumber() != userDetails.getAdhaarNumber()) {
						registeredUserDetails.add(userDetails);
						return true;
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static Set<UserDetails> registeredUsersList() {
		return registeredUserDetails;
	}

	public static boolean registeredAccountDetails(AccountDetails accountDetails) {
		if (registeredAccountDetails.add(accountDetails)) {
			return true;
		}
		return false;
	}

	public static boolean approvedUserDetails(UserCredentials userCredentials, UserDetails userDetails) {
		if (userCredentials != null && userDetails != null) {
			credentialsAndDetails.put(userCredentials, userDetails);
			return true;
		} else {
			return false;
		}
	}

	public static Map<UserCredentials, UserDetails> approvedUserDetails() {
		return credentialsAndDetails;
	}

	public static boolean registeredAccountHolders(UserCredentials userCredentials, AccountDetails accountDetails) {
		if (userCredentials != null && accountDetails != null) {
			credentialsAndAccount.put(userCredentials, accountDetails);
			return true;
		} else {
			return false;
		}
	}

	public static Map<UserCredentials, AccountDetails> registeredAccountHolders() {
		return credentialsAndAccount;
	}

	public static boolean fundsTransfer(FundTransfer fundTransfer) {
		if (fundsTransferList.add(fundTransfer))
			return true;
		else
			return false;
	}

	public static List<FundTransfer> fundTransfer() {
		return fundsTransferList;
	}

	public static boolean chequeBook(long accountNumber, String status) {
		if (accountNumber != 0 && status != null) {
			chequeBook.put(accountNumber, status);
			return true;
		} else {
			return false;
		}
	}

	public static Map<Long, String> chequeBookList() {
		return chequeBook;
	}

}
