package com.revature.data;

import com.revature.hibernate.beans.Login;

public interface LoginDAO {

	public int addUser(Login user);
	
	
	public Login getLogin(String username, String password);
	
	public Login getLogin(Login l);
	
	public Login getLoginById(Login l);
	
	public void deleteLogin(Login l);
	
	public void updateLogin(Login l);
}
