package com.lucas.cursows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursows.entities.Categoria;
import com.lucas.cursows.entities.Pedido;
import com.lucas.cursows.repositories.CategoriaRepository;
import com.lucas.cursows.repositories.PedidoRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodos(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarPorId(long id) {
		Optional<Categoria> objeto = categoriaRepository.findById(id);
		return objeto.get();
	}
	
	

}
