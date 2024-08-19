package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
}
