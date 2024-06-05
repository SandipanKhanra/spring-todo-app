package com.nitaigauranga.springboot.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("nitai");
		boolean isValidPassword = password.equalsIgnoreCase("108");
		return isValidUsername && isValidPassword;
	}
}
