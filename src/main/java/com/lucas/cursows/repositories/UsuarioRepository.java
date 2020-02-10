package com.lucas.cursows.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucas.cursows.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
