package com.bankingsystem.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import com.bankingsystem.beans.AccountDetails;
import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.beans.UserDetails;
import com.bankingsystem.repository.UsersRepository;

public class AccountHolder {

	public static boolean accountDetails(String accountType, double amount, String userName, String userPassword,
			String userRole) {
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountType(accountType);
		final long accountNum = accountNumber();
		accountDetails.setAccountNumber(accountNum);
		accountDetails.setAmount(amount);
		accountDetails.setOpeningDate(LocalDate.now());
		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUserName(userName);
		userCredentials.setUserPassword(userPassword);
		userCredentials.setUserRole(userRole);
		return UsersRepository.registeredAccountHolders(userCredentials, accountDetails);
	}

	private static long accountNumber() {
		long accountNumber = (long) (Math.random() * 50000 + 10000);
		return accountNumber;
	}

	public static boolean userDetails(long adhaar, String userName, String userPassword, String userRole) {
		Set<UserDetails> usersList = UsersRepository.registeredUsersList();
		Iterator<UserDetails> users = usersList.iterator();
		while (users.hasNext()) {
			UserDetails details = (UserDetails) users.next();
			String firstName, lastName;
			LocalDate dob;
			long phoneNumber, adhaarNumber;
			if (adhaar == details.getAdhaarNumber()) {
				firstName = details.getFirstName();
				lastName = details.getLastName();
				dob = details.getDateOfBirth();
				phoneNumber = details.getPhoneNumber();
				adhaarNumber = details.getAdhaarNumber();

				UserDetails userDetails = new UserDetails();
				userDetails.setFirstName(firstName);
				userDetails.setLastName(lastName);
				userDetails.setDateOfBirth(dob);
				userDetails.setPhoneNumber(phoneNumber);
				userDetails.setAdhaarNumber(adhaarNumber);

				UserCredentials userCredentials = new UserCredentials();
				userCredentials.setUserName(userName);
				userCredentials.setUserPassword(userPassword);
				userCredentials.setUserRole(userRole);

				return UsersRepository.approvedUserDetails(userCredentials, userDetails);

			}
		}
		return false;
	}
}
