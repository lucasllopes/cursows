package com.lucas.cursows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.repositories.UsuarioRepository;

@Service
public class UsuarioService  {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorId(long id) {
		Optional<Usuario> objeto = usuarioRepository.findById(id);
		return objeto.get();
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
		
	}
	
	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	

}
