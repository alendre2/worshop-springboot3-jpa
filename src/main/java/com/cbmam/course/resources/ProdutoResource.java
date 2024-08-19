package com.cbmam.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbmam.course.entities.Produto;
import com.cbmam.course.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}
