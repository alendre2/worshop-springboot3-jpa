package com.cbmam.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbmam.course.entities.Usuario;
import com.cbmam.course.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;
    
    public List<Usuario> buscarTodos(){
        return repositorio.findAll();
    }
    
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> obj = repositorio.findById(id);
        return obj.orElse(null); // Melhor usar orElse(null) em vez de get()
    }
    
    public Usuario insert(Usuario obj) {
        System.out.println("Tentando inserir usuário: " + obj); // Log detalhado
        Usuario salvo = repositorio.save(obj);
        System.out.println("Usuário salvo com sucesso: " + salvo); // Log após a inserção
        return salvo;
    }

    
}
