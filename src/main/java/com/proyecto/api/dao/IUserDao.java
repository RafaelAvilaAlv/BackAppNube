package com.proyecto.api.dao;
 

 

import org.springframework.data.repository.CrudRepository;
import com.proyecto.api.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {
	
	User findByUsuarioAndContrasena(String usuario, String contrasena);



}
