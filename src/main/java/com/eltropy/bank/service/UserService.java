package com.eltropy.bank.service;

import java.util.List;



import com.eltropy.bank.entity.User;

public interface UserService {
    void save(User user);
    void deleteById(long theId);
    
    User findByUsername(String username);
    
    List<User> findBySpecificRole(String role);
}