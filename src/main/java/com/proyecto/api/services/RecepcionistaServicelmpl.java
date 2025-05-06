package com.proyecto.api.services;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.api.dao.*;
import com.proyecto.api.entity.*;

@Service
public class RecepcionistaServicelmpl implements IRecepcionistaService {

    @Autowired
    private IRecepcionistaDao recepDao;

    @Override
    @Transactional(readOnly = true)
    public List<Recepcionista> findAll() {
        return (List<Recepcionista>) recepDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Recepcionista findById(Long id) {
        return recepDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Recepcionista save(Recepcionista enca) {
        return recepDao.save(enca);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        recepDao.deleteById(id);
    }

    @Override
    public List<Recepcionista> getBooksByTitle(String usuario) {
        return recepDao.findByUsuarioContainingIgnoreCase(usuario);
    }
}

