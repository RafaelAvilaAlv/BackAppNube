package com.proyecto.api.dao;

 

import org.springframework.data.repository.CrudRepository;
import com.proyecto.api.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, String> {

    boolean existsById(String cedula);
}
