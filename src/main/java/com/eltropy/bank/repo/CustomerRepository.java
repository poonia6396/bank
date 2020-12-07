package com.eltropy.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eltropy.bank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
}