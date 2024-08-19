package com.cbmam.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbmam.course.entities.Usuario;
import com.cbmam.course.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
    	obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);

    }
}
