package com.proyecto.api.controllers;

 

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.api.entity.Recepcionista;
import com.proyecto.api.services.IRecepcionistaService;

@RestController
@RequestMapping("/api")
public class RecepcionistaController {

    @Autowired
    private IRecepcionistaService recepcionistaService;

    @GetMapping("/recepcionistas")
    public List<Recepcionista> index() {
        return recepcionistaService.findAll();
    }

    @GetMapping("/recepcionistas/{id}")
    public Recepcionista show(@PathVariable Long id) {
        return recepcionistaService.findById(id);
    }

    @PostMapping("/recepcionistas")
    @ResponseStatus(HttpStatus.CREATED)
    public Recepcionista create(@RequestBody Recepcionista recepcionista) {
        return recepcionistaService.save(recepcionista);
    }

    @PutMapping("/recepcionistas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Recepcionista update(@RequestBody Recepcionista recepcionista, @PathVariable Long id) {
        Recepcionista recepcionistaActual = recepcionistaService.findById(id);
        recepcionistaActual.setUsuario(recepcionista.getUsuario());
        recepcionistaActual.setContrasena(recepcionista.getContrasena());
        return recepcionistaService.save(recepcionistaActual);
    }

    @DeleteMapping("/recepcionistas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        recepcionistaService.delete(id);
    }

    @GetMapping("/recepcionistas/usuario/{usuario}")
    public ResponseEntity<?> getClientes(@PathVariable String usuario) {
        try {
            Long id = Long.parseLong(usuario);
            Recepcionista recep = recepcionistaService.findById(id);
            if (recep != null) {
                return new ResponseEntity<>(recep, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            List<Recepcionista> receps = recepcionistaService.getBooksByTitle(usuario);
            if (!receps.isEmpty()) {
                return new ResponseEntity<>(receps, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Clientes no encontrados", HttpStatus.NOT_FOUND);
            }
        }
    }
}
