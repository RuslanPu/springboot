package com.example.springboot.service;

import com.example.springboot.model.Role;
import com.example.springboot.model.User;


import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void add(User user, String[] checkboxRoles);
    void edit(User user, String[] checkboxRoles);
    void delete(User user);
    User getUserById(Long id);
    void addRole(Role role);
    boolean unicEmail(String email);
}
