package com.eltropy.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltropy.bank.entity.Account;
import com.eltropy.bank.entity.Customer;
import com.eltropy.bank.repo.AccountRepository;
import com.eltropy.bank.repo.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
    private AccountRepository accountRepository;
	
	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
	}

	@Override
	public void deleteById(long theId) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(theId);
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account getAccount(long theId) {
		// TODO Auto-generated method stub
		return accountRepository.getOne(theId);
	}

	@Override
	public List<Account> findByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return accountRepository.findByCustomer(customer);
	}

}
