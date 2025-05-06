package com.proyecto.api.services;

 

import java.util.List;
import com.proyecto.api.entity.Role;

public interface IRoleService {

    public List<Role> findAll();

    public Role save(Role role);

    public Role findById(Long id);

    public void delete(Long id);
}
