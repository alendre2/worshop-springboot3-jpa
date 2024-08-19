package com.cbmam.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbmam.course.entities.Pedido;
import com.cbmam.course.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarTodos(){
		List<Pedido> list = service.buscarTodos();
		return ResponseEntity.ok().body(list);
	}		
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
		Pedido obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
