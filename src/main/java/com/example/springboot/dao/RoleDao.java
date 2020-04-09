package com.example.springboot.dao;

import com.example.springboot.model.Role;


public interface RoleDao {
    void add(Role role);
    Role getRoleById(Long id);
}
