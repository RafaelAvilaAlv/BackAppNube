package com.proyecto.api.services;

 

import java.util.List;
import com.proyecto.api.entity.Cliente;

public interface IClienteService {

    List<Cliente> getBooksByTitle(String usuario);

    public List<Cliente> findAll();

    public Cliente save(Cliente cliente);

    public Cliente findById(Long idCliente);

    public void delete(Long idCliente);
}
