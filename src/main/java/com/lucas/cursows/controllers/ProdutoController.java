package com.lucas.cursows.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cursows.entities.Produto;
import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.services.ProdutoService;
import com.lucas.cursows.services.UsuarioService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<Produto>> buscarTodos(){

		List<Produto> listaProdutos = produtoService.buscarTodos();
		
		return ResponseEntity.ok().body(listaProdutos);		
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
		Produto produto = produtoService.buscarPorId(id);
		
		return ResponseEntity.ok(produto);
	}	

}