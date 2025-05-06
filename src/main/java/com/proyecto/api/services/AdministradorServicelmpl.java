package com.proyecto.api.services;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.api.dao.*;
import com.proyecto.api.entity.*;

@Service
public class AdministradorServicelmpl implements IAdministradorService {

    @Autowired
    private IAdministradorDao adminDao;

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> findAll() {
        return (List<Administrador>) adminDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Administrador findById(Long id) {
        return adminDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Administrador save(Administrador admin) {
        return adminDao.save(admin);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        adminDao.deleteById(id);
    }

    @Override
    public List<Administrador> getBooksByTitle(String usuario) {
        return adminDao.findByUsuarioContainingIgnoreCase(usuario);
    }
}
