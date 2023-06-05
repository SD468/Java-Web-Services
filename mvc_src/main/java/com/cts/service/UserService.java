package com.cts.service;

import com.cts.dto.User;
import com.cts.exception.UserNotFoundException;

public interface UserService {

	public User login(User user) throws UserNotFoundException ;
}
