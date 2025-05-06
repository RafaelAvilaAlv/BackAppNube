package com.proyecto.api.dao;

 

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.proyecto.api.entity.Recepcionista;

public interface IRecepcionistaDao extends CrudRepository<Recepcionista, Long> {

    Recepcionista findByUsuario(String usuario);

    List<Recepcionista> findByUsuarioContainingIgnoreCase(String usuario);
}

