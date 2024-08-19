package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
