package com.bankingsystem.dao;

import java.util.Iterator;
import java.util.Set;

import com.bankingsystem.beans.UserDetails;
import com.bankingsystem.repository.UsersRepository;

public class CheckAdhaarNumber {
	
	public static boolean isAdhaarExist(long adhaar) {
		Set<UserDetails> usersList = UsersRepository.registeredUsersList();
		Iterator<UserDetails> users = usersList.iterator();
		while (users.hasNext()) {
			UserDetails userDetails = (UserDetails) users.next();
			if(adhaar == userDetails.getAdhaarNumber())
				return true;			
		}
		return false;	
	}

}
