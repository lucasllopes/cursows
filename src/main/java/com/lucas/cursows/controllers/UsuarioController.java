package com.lucas.cursows.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.services.UsuarioService;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController { 
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos(){

		List<Usuario> listaUsuarios = usuarioService.buscarTodos();
		
		return ResponseEntity.ok().body(listaUsuarios);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
		Usuario user = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok(user);
	}
	
	
	

}
