package com.eltropy.bank.service;

public interface SecurityService {
	 String findLoggedInUsername();

	 void autoLogin(String username, String password);
}
