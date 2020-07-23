package com.capgemini.jdbc.factory;

import com.capgemini.jdbc.DAO.UserDAO;
import com.capgemini.jdbc.DAO.UserDAOJDBCImpl;

public class UserFactory {

	public static UserDAO getInstance() {
		UserDAO dao = new UserDAOJDBCImpl();
		return dao;
	}

}
