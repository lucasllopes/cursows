package com.lucas.cursows.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cursows.entities.Pedido;
import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.services.PedidoService;
import com.lucas.cursows.services.UsuarioService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<Pedido>> buscarTodos(){

		List<Pedido> listaPedidos = pedidoService.buscarTodos();
		
		return ResponseEntity.ok().body(listaPedidos);		
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
		Pedido user = pedidoService.buscarPorId(id);
		
		return ResponseEntity.ok(user);
	}
	

}
