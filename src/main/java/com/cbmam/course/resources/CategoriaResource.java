package com.cbmam.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbmam.course.entities.Categoria;
import com.cbmam.course.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;
    
    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos() {
        List<Categoria> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}
