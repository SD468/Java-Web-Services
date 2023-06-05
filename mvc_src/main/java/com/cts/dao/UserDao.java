package com.cts.dao;

import org.springframework.stereotype.Repository;

import com.cts.dto.User;

@Repository
public interface UserDao {
	
	public User login(User user) ;
}
