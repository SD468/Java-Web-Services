package com.cts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.dto.User;

@Repository
public class UserDaoIml implements UserDao {
	
	private static final String SQL_SELECT_USER = "select * from userLogin where userName=? and password=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User login(User user) throws EmptyResultDataAccessException{
		return  jdbcTemplate.queryForObject(SQL_SELECT_USER, 
				(rs, rc) -> new User(rs.getString("userName"), rs.getString("password")),
				user.getUserName(), user.getPassword());
	}

}
