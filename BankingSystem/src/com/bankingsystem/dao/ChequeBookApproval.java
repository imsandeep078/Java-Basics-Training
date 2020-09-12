package com.bankingsystem.dao;

import java.util.Iterator;
import java.util.Map;

import com.bankingsystem.repository.UsersRepository;

public class ChequeBookApproval {

	static Map<Long, String> chequeBook = UsersRepository.chequeBookList();

	public static boolean chequeBookRequestList() {
		if (chequeBook.size() != 0 && chequeBook.containsValue("requested")) {
			System.out.println("\t--------List of Requests--------");
			System.out.println("\tAccount No.\tStatus");
			Iterator<Map.Entry<Long, String>> requestsList = chequeBook.entrySet().iterator();
			while (requestsList.hasNext()) {
				Map.Entry<Long, String> entry = (Map.Entry<Long, String>) requestsList.next();
				if (entry.getValue().equals("requested")) {
					long accountNumber = entry.getKey();
					String status = entry.getValue();
					System.out.println("\t" + accountNumber + "\t\t" + status);
					return true;
				}

			}
		}
		return false;
	}

	public static boolean isApproved(long accountNumber) {
		Iterator<Map.Entry<Long, String>> requestsList = chequeBook.entrySet().iterator();
		while (requestsList.hasNext()) {
			Map.Entry<Long, String> entry = (Map.Entry<Long, String>) requestsList.next();
			if (entry.getKey() == accountNumber && entry.getValue().equals("requested")) {
				entry.setValue("approved");
				return true;
			}

		}
		return false;
	}

}
