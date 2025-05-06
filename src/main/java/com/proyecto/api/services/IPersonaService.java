package com.proyecto.api.services;

 

import java.util.List;
import com.proyecto.api.entity.Persona;

public interface IPersonaService {

    public List<Persona> findAll();

    public Persona save(Persona persona);

    public Persona findById(String cedulaPersona);

    public void delete(String cedulaPersona);

    boolean verificarCedulaExistente(String cedula);
}

