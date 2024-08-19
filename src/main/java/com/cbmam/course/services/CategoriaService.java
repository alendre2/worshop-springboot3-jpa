package com.cbmam.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbmam.course.entities.Categoria;
import com.cbmam.course.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;
	
	public List<Categoria> buscarTodos(){
		return repositorio.findAll();
	}
	
	public Categoria buscarPorId(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
	
}
