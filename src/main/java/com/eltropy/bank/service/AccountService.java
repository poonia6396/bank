package com.eltropy.bank.service;

import java.util.List;

import com.eltropy.bank.entity.Account;
import com.eltropy.bank.entity.Customer;


public interface AccountService {
	void save(Account account);
	 void deleteById(long theId);
	 List<Account> getAccounts();
	 Account getAccount(long theId);
	List<Account> findByCustomer(Customer customer);
}
