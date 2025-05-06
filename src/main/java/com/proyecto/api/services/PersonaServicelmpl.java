package com.proyecto.api.services;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.api.dao.*;
import com.proyecto.api.entity.*;

@Service
public class PersonaServicelmpl implements IPersonaService {

    @Autowired
    private IPersonaDao persoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) persoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(String id) {
        return persoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        if (persoDao.existsById(persona.getCedula_persona())) {
            return persoDao.save(persona); // Actualiza si ya existe
        } else {
            if (persoDao.existsById(persona.getCedula_persona())) {
                throw new RuntimeException("La cédula " + persona.getCedula_persona() + " ya está registrada.");
            }
            return persoDao.save(persona); // Crea nuevo registro
        }
    }

    @Override
    @Transactional
    public void delete(String id) {
        persoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean verificarCedulaExistente(String cedula) {
        return persoDao.existsById(cedula);
    }
}
