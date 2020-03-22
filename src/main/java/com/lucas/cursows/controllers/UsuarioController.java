package com.lucas.cursows.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController { 
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/buscarTodos")
	public ResponseEntity<List<Usuario>> buscarTodos(){

		List<Usuario> listaUsuarios = usuarioService.buscarTodos();
		
		return ResponseEntity.ok().body(listaUsuarios);		
	}
	
	@GetMapping(value = "/buscarPorId/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
		Usuario user = usuarioService.buscarPorId(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioRetorno = usuarioService.inserirUsuario(usuario);		
		
		/* A criao de um novo recurso deve retornar o codigo 201, e nao 200. 
		 * o metodo .created precisa de uma URI, ou seja, endereco na qual o recurso esta armazenado/disponivel,
		 * esse endereco sera exibido no cabecalho do retorno da requisicao, na key 'location' 
		 */
	    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/buscarPorId/{id}").
	    									 buildAndExpand(usuarioRetorno.getId()).toUri(); 
	    
	    
		
		return ResponseEntity.created(uri).body(usuarioRetorno);		
	}
	
	@DeleteMapping(value = "/deletarUsuario/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
		usuarioService.deletarUsuario(id);
		
		return  ResponseEntity.noContent().build();		
		
	}
	
	@PutMapping(value = "/atualizarUsuario/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id,@RequestBody Usuario usuario){
		Usuario usuarioRequisicao = usuarioService.atualizarUsuario(id, usuario);
		
		return ResponseEntity.ok().body(usuarioRequisicao);		
		
	}
	
	

}
