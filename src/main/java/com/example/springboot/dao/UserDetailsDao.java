package com.example.springboot.dao;

import com.example.springboot.model.User;


public interface UserDetailsDao {

    User getUserByName(String username);

}
