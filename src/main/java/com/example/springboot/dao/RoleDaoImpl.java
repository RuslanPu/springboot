package com.example.springboot.dao;

import com.example.springboot.model.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    public EntityManager entityManager;



    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
