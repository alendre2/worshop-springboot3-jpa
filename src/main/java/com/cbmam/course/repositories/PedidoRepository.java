package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbmam.course.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
