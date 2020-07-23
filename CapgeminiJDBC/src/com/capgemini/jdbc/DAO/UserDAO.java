package com.capgemini.jdbc.DAO;

import java.util.List;

import com.capgemini.jdbc.beans.UserBean;

public interface UserDAO {
	public List<UserBean> getAllInfo();

	public UserBean getInfo(int userid);

	public UserBean userLogin(int userid, String password);
	
	public UserBean userInsert(int userid,String username,String email,String password);
	
	public UserBean userDelete(int userid,String password);
	
	public UserBean userUpdate(String email,int userid, String password);

}
