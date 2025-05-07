package com.proyecto.api.repository;
import com.proyecto.api.entity.Usuario;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
    Optional<Usuario> findByCorreoAndClave(String correo, String clave);
}