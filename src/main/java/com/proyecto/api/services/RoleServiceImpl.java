package com.proyecto.api.services;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.api.dao.*;
import com.proyecto.api.entity.*;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return (List<Role>) roleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Long id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        roleDao.deleteById(id);
    }
}
