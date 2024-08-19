package com.cbmam.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbmam.course.entities.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
}
