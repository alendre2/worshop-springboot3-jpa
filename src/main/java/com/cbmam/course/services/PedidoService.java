package com.cbmam.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbmam.course.entities.Pedido;
import com.cbmam.course.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositorio;
	
	public List<Pedido> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
	
}
