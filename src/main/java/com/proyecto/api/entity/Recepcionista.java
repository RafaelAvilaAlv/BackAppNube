package com.proyecto.api.entity;

 

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "recepcionistas", uniqueConstraints = {@UniqueConstraint(columnNames = {"cedula_persona", "idRecepcionista"})})
public class Recepcionista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionista;

    private String usuario;
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula_persona")
    private Persona persona;


	public Long getIdRecepcionista() {
		return idRecepcionista;
	}

	public void setIdRecepcionista(Long idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


    
}
