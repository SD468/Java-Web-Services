package com.cts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.dao.UserDao;
import com.cts.dto.User;
import com.cts.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger logger =LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao dao;

	@Override
	public User login(User user) throws UserNotFoundException {
		logger.info("Start");
		 User login = null ;
		 try {
		 login=dao.login(user);
		 logger.debug("User details",login);
		 }catch(EmptyResultDataAccessException e) {
			 throw new UserNotFoundException("Invalid User");
		 }
		logger.info("End");
		return login;
	}

}
