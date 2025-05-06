package com.proyecto.api.services;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.api.dao.*;
import com.proyecto.api.entity.*;

@Service
public class ClienteServicelmpl implements IClienteService {

    @Autowired
    private IClienteDao cliDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) cliDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return cliDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cli) {
        return cliDao.save(cli);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cliDao.deleteById(id);
    }

    @Override
    public List<Cliente> getBooksByTitle(String usuario) {
        return cliDao.findByUsuarioContainingIgnoreCase(usuario);
    }
}

