package com.cbmam.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbmam.course.entities.Produto;
import com.cbmam.course.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;
	
	public List<Produto> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}
	
}
