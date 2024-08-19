package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
