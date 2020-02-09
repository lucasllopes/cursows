package com.lucas.cursows.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cursows.entities.Usuario;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController { 
	
	@GetMapping
	public ResponseEntity<Usuario> buscarTodos(){
		Usuario usuario = new Usuario(1l,"Lucas Lopes","lucas@gmail.com","999999999","abc123");
		
		return ResponseEntity.ok().body(usuario);		
	}
	
	

}
