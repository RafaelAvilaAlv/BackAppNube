package com.proyecto.api.dao;

 

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.proyecto.api.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

    Cliente findByUsuario(String usuario);

    List<Cliente> findByUsuarioContainingIgnoreCase(String usuario);
}

