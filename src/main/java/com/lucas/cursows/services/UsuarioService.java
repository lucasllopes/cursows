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
	
	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		Usuario entidade = usuarioRepository.getOne(id); // getOne prepara o objeto de modo que fique monitorado pelo JPA
													     //para voce manipula-lo e depois realizar alguma operacao no banco  
		
		atualizarDadosUsuario(entidade,usuario); // atualiza dados da entidade, baseado no usuario(parametro do metodo atualizarUsuario).
												 // No final da execucao desse metodo, 
		                                         //o atributo entidade esta atualizado com os dados do atributo usuario
		
		return usuarioRepository.save(entidade);
		
		
		
	}

	private void atualizarDadosUsuario(Usuario entidade, Usuario usuario) {
         entidade.setNome(usuario.getNome());
         entidade.setEmail(usuario.getEmail());
         entidade.setTelefone(usuario.getTelefone());
		
		
	}
	
	

}
