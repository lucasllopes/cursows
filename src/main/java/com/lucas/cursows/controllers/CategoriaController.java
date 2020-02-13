package com.lucas.cursows.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cursows.entities.Categoria;
import com.lucas.cursows.entities.Pedido;
import com.lucas.cursows.services.CategoriaService;
import com.lucas.cursows.services.PedidoService;

	@RestController
	@RequestMapping(value = "/categorias")
    public class CategoriaController {
	
		@Autowired
		private CategoriaService categoriaService;
	
		@GetMapping(value ="/buscarTodos")
		public ResponseEntity<List<Categoria>> buscarTodos() {
	
			List<Categoria> listaCategorias = categoriaService.buscarTodos();
	
			return ResponseEntity.ok().body(listaCategorias);
		}
	
		@GetMapping(value = "/buscarPorId/{id}")
		public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
			Categoria categoria = categoriaService.buscarPorId(id);
	
			return ResponseEntity.ok(categoria);
		}
	}
