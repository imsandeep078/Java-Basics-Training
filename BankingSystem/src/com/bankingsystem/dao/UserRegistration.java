package com.bankingsystem.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.bankingsystem.beans.UserDetails;
import com.bankingsystem.repository.UsersRepository;

public class UserRegistration {

	public static String userRegistration(String firstName, String lastName, String dateOfBirth, long phoneNumber,
			long adhaarNumber) {

		UserDetails userDetails;
		try {
			userDetails = new UserDetails();
			userDetails.setFirstName(firstName);
			userDetails.setLastName(lastName);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
			userDetails.setDateOfBirth(dob);
			userDetails.setPhoneNumber(phoneNumber);
			userDetails.setAdhaarNumber(adhaarNumber);
			if (UsersRepository.registeredUserDetails(userDetails))
				return "Registered Successfully...";
			else
				return "As We found ADHAAR NUMBER "+adhaarNumber+ " Already Exist\n"
						+ "\tSo We Are Unbale To Register User";
			
		} catch (DateTimeParseException e) {
			return e.getMessage();
		}
	}

}
