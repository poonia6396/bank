package com.eltropy.bank.service;

import java.util.List;

import com.eltropy.bank.entity.Customer;

public interface CustomerService {
	 void save(Customer customer);
	 void deleteById(long theId);
	 List<Customer> getCustomers();
	 Customer getCustomer(long theId);
}
