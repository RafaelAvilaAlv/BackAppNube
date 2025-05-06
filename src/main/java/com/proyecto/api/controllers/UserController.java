package com.proyecto.api.controllers;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.api.entity.User;
import com.proyecto.api.services.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/usuarios")
    public List<User> index() {
        return userService.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public User show(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user, @PathVariable Long id) {
        User userActual = userService.findById(id);
        userActual.setUsuario(user.getUsuario());
        userActual.setContrasena(user.getContrasena());
        userActual.setPersona(user.getPersona());
        userActual.setRol(user.getRol());
        return userService.save(userActual);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        User user = userService.findByUsuarioAndContrasena(loginUser.getUsuario(), loginUser.getContrasena());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

}
