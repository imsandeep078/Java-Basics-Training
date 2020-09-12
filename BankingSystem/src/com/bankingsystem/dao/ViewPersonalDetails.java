package com.bankingsystem.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.beans.UserCredentials;
import com.bankingsystem.beans.UserDetails;
import com.bankingsystem.repository.UsersRepository;

public class ViewPersonalDetails {

	public static void viewPersonalDetails(String userName, String userPassword) {
		Map<UserCredentials, UserDetails> details = UsersRepository.approvedUserDetails();
		Iterator<Map.Entry<UserCredentials, UserDetails>> credentialsAndDetails = details.entrySet().iterator();
		while (credentialsAndDetails.hasNext()) {
			Map.Entry<UserCredentials, UserDetails> entry = (Map.Entry<UserCredentials, UserDetails>) credentialsAndDetails
					.next();
			if(entry.getKey().getUserName().equals(userName) && entry.getKey().getUserPassword().equals(userPassword)) {
				String firstName = entry.getValue().getFirstName();
				String lastName = entry.getValue().getLastName();
				LocalDate dob = entry.getValue().getDateOfBirth();
				long adhaar = entry.getValue().getAdhaarNumber();
				long phone = entry.getValue().getPhoneNumber();
				System.out.println("\t-------------------------------PERSONAL DETAILS-------------------------------");
				System.out.println("\tFirst Name\tLast Name\tDate of Birth\tPhone No.\tAdhaar No.");
				System.out.println("\t" + firstName + "\t\t" + lastName + "\t\t" + dob + "\t" + phone + "\t" + adhaar);
				System.out.println("\t------------------------------------------------------------------------------");
			}
			
		}
	}
}
