package com.capgemini.jdbc.DAO;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.jdbc.beans.UserBean;

public class UserDAOJDBCImpl implements UserDAO {
	FileReader reader=null;
	Properties prop=null;
	UserBean user=null;
	

	public UserDAOJDBCImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("db.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserBean getInfo(int userid) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password")); 
			PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("query2"))) {
				 
			pstmt.setInt(1, userid);
			try(ResultSet rs=pstmt.executeQuery()) {
				if(rs.next()) {
					user=new UserBean();
					user.setUserid(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setEmail(rs.getString(3));
				}
				return user;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public UserBean userLogin(int userid, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password")); 
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("loginquery"))) {
					 
				pstmt.setInt(1, userid);
				pstmt.setString(2,password); 
				try(ResultSet rs=pstmt.executeQuery()) {
					if(rs.next()) {
						user=new UserBean();
						user.setUserid(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setEmail(rs.getString(3));
					}
					return user;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public List<UserBean> getAllInfo() {
		List<UserBean> userlist=new ArrayList<UserBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password")); 
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(prop.getProperty("query"));) {
			
					 
				while(rs.next())
					{
						user=new UserBean();
						user.setUserid(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setEmail(rs.getString(3));
						userlist.add(user);
					}
					return userlist;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		return null;
	}
	@Override
	public UserBean userInsert(int userid, String username, String email, String password) {

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password")); 
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("insertquery"))) {
					 
				pstmt.setInt(1, userid);
				pstmt.setString(2,username); 
				pstmt.setString(3, email);
				pstmt.setString(4, password);
				
				int count=pstmt.executeUpdate();
				
				if(count>0) {
					System.out.println("Data Inserted");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public UserBean userDelete(int userid, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password")); 
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("deletequery"))) {
					 
				pstmt.setInt(1, userid);
				pstmt.setString(2,password); 

				int count=pstmt.executeUpdate();
				
				if(count>0) {
					System.out.println("Data Deleted");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public UserBean userUpdate(String email,int userid, String password) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("user"),prop.getProperty("password")); 
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("updatequery"))) {
				
				pstmt.setString(1, email);
				pstmt.setInt(2, userid);
				pstmt.setString(3,password); 
				

				int count=pstmt.executeUpdate();
				
				if(count>0) {
					System.out.println("Data updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

}
