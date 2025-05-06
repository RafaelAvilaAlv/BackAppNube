package com.proyecto.api.services;

 

import java.util.List;
import com.proyecto.api.entity.User;

public interface IUserService {

    public List<User> findAll();

    public User save(User user);

    public User findById(Long id);

    public void delete(Long id);

    User findByUsuarioAndContrasena(String usuario, String contrasena);

}

