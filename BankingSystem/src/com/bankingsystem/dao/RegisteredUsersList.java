package com.bankingsystem.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import com.bankingsystem.beans.UserDetails;
import com.bankingsystem.repository.UsersRepository;

public class RegisteredUsersList {

	public static void registeredUserList() {
		Set<UserDetails> registeredUserDetails = UsersRepository.registeredUsersList();
		System.out.println("\t------------------------------------------------------------------------------");
		System.out.println("\tFirst Name\tLast Name\tDate of Birth\tPhone No.\tAdhaar No.");
		Iterator<UserDetails> users = registeredUserDetails.iterator();
		while (users.hasNext()) {
			UserDetails userDetails = (UserDetails) users.next();
			String firstName = userDetails.getFirstName();
			String lastName = userDetails.getLastName();
			LocalDate dob = userDetails.getDateOfBirth();
			long phoneNo = userDetails.getPhoneNumber();
			long adhaar = userDetails.getAdhaarNumber();
			System.out.println("\t" + firstName + "\t\t" + lastName + "\t\t" + dob + "\t" + phoneNo + "\t" + adhaar);
		}
		System.out.println("\t------------------------------------------------------------------------------");
	}
}
