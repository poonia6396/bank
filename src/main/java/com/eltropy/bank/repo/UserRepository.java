package com.eltropy.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eltropy.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    @Query( "select u from User u inner join u.roles r where r.name = :role" )
    List<User> findBySpecificRole(@Param("role") String role);
    
}