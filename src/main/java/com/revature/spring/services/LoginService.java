package com.revature.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.LoginDAO;
import com.revature.hibernate.beans.Login;

@Service
@Transactional(readOnly=true)
public class LoginService {
	@Autowired
	LoginDAO loginDao;
	
	@Transactional(readOnly=false)
	public int addUser(Login user) {
		return loginDao.addUser(user);
	}
	
	public Login getLogin(String username, String password) {
		return loginDao.getLogin(username, password);
	}
	
	public Login getLogin(Login login) {
		return loginDao.getLogin(login);
	}
	
	public Login getLoginById(Login login) {
		return loginDao.getLoginById(login);
	}

	@Transactional(readOnly=false)
	public void deleteLogin(Login login) {
		loginDao.deleteLogin(login);
	}

	@Transactional(readOnly=false)
	public void updateLogin(Login login) {
		loginDao.updateLogin(login);
	}
}
