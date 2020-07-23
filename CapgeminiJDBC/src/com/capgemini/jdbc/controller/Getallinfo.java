package com.capgemini.jdbc.controller;

import java.util.List;

import com.capgemini.jdbc.DAO.UserDAO;
import com.capgemini.jdbc.beans.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class Getallinfo {

	public static void main(String[] args) {
		UserDAO dao = UserFactory.getInstance();
		List<UserBean> userlist = dao.getAllInfo();

		if (userlist != null) {
			for (UserBean user : userlist) {
				System.out.println(user);
			}
		} else {
			System.out.println("Something went wrong.....");
		}

	}

}
