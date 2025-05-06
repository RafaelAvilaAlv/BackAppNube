package com.proyecto.api.controllers;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.proyecto.api.entity.Role;
import com.proyecto.api.services.IRoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/roles")
    public List<Role> index() {
        return roleService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role show(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Role create(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PutMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Role update(@RequestBody Role role, @PathVariable Long id) {
        Role roleActual = roleService.findById(id);
        roleActual.setNombre(role.getNombre());
        roleActual.setDescripcion(role.getDescripcion());
        return roleService.save(roleActual);
    }

    @DeleteMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
