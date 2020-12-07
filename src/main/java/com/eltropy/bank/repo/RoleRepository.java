package com.eltropy.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eltropy.bank.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	List<Role> findByName(String roleName);
	
}