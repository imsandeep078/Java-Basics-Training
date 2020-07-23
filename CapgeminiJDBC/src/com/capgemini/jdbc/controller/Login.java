package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.DAO.UserDAO;
import com.capgemini.jdbc.beans.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class Login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAO dao = UserFactory.getInstance();
		System.out.println("Enter User Id...");
		int userid = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Password..");
		String password = sc.nextLine();
		UserBean user = dao.userLogin(userid, password);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("Somethimg went wrong...");
		}
		sc.close();
	}

}
