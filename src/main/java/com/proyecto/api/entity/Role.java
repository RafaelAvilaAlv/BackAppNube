package com.proyecto.api.entity;

 

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    private String nombre;
    private String descripcion;

    // Getters y Setters
}
