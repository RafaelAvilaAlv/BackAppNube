package com.proyecto.api.controllers;
 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.api.entity.Persona;
import com.proyecto.api.services.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonasController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> index() {
        return personaService.findAll();
    }

    @GetMapping("/personas/{id}")
    public Persona show(@PathVariable String id) {
        return personaService.findById(id);
    }

    @PostMapping("/personas")
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        if (personaService.verificarCedulaExistente(persona.getCedula_persona())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Persona nuevaPersona = personaService.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPersona);
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona, @PathVariable String id) {
        Persona personaActual = personaService.findById(id);
        personaActual.setNombre(persona.getNombre());
        personaActual.setNombre2(persona.getNombre2());
        personaActual.setApellido(persona.getApellido());
        personaActual.setApellido2(persona.getApellido2());
        personaActual.setGenero(persona.getGenero());
        personaActual.setDireccion(persona.getDireccion());
        personaActual.setTelefono(persona.getTelefono());
        personaActual.setEdad(persona.getEdad());
        personaActual.setNombreContactoEmergencia(persona.getNombreContactoEmergencia());
        personaActual.setTelefonoContactoEmergencia(persona.getTelefonoContactoEmergencia());
        personaActual.setParentescoContactoEmergencia(persona.getParentescoContactoEmergencia());
        personaActual.setNombreContactoEmergencia2(persona.getNombreContactoEmergencia());
        personaActual.setTelefonoContactoEmergencia2(persona.getTelefonoContactoEmergencia());
        personaActual.setParentescoContactoEmergencia2(persona.getParentescoContactoEmergencia());
        return personaService.save(personaActual);
    }

    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        personaService.delete(id);
    }

    @GetMapping("/verificarCedula/{cedula}")
    public boolean verificarCedulaExistente(@PathVariable String cedula) {
        return personaService.verificarCedulaExistente(cedula);
    }
}
