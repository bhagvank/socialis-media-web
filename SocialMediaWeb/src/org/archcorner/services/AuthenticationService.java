package org.archcorner.services;

import org.archcorner.dal.dao.UserDAO;
import org.archcorner.pojo.User;

public class AuthenticationService {
	
	public int getHighestId()
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getHighestId();
	}

	public User getUser(String userName)
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getUser(userName);
	}
	public User getUserById(int userIdNo)
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getUserById(userIdNo);
	}
}
