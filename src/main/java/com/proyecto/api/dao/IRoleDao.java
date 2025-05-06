package com.proyecto.api.dao;

import org.springframework.data.repository.CrudRepository;
import com.proyecto.api.entity.Role;

public interface IRoleDao extends CrudRepository<Role, Long> {
}
