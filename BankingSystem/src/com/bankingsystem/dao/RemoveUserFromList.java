package com.bankingsystem.dao;

import com.bankingsystem.repository.UsersRepository;

public class RemoveUserFromList {

	public static boolean removeUserFromList(long adhaar) {
		if(UsersRepository.registeredUsersList().removeIf(userDetails -> userDetails.getAdhaarNumber() == adhaar)) {
			return true;
		}
		return false;	
	}

}
