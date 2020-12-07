package com.eltropy.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eltropy.bank.entity.Account;
import com.eltropy.bank.entity.Customer;


public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByCustomer(Customer customer);
}
