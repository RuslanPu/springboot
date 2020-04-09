package com.example.springboot.dao;

import com.example.springboot.model.Role;

import java.util.List;


public interface RoleDao {
    void add(Role role);
    Role getRoleById(Long id);
    List<Role> getAllRole();
}
