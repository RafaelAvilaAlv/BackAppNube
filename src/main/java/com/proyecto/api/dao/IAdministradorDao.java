package com.proyecto.api.dao;

 

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.proyecto.api.entity.Administrador;

public interface IAdministradorDao extends CrudRepository<Administrador, Long> {
    
    Administrador findByUsuario(String usuario);

    List<Administrador> findByUsuarioContainingIgnoreCase(String usuario);
}
