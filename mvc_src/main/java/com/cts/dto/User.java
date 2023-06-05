package com.cts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
	
	@NotEmpty
	@Size(min=4,message = "User Name should be more than 3 letter")
	private String userName;
	@NotEmpty
	@Size(min=4,message = "Password should be more than 3 letter")
	private String password;
	
	public User() {
	}

	
	public User(String userName, String password) {
		super();		
		this.userName = userName;
		this.password = password;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	
	
	

}
