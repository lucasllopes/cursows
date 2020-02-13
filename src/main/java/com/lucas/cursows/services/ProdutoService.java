package com.lucas.cursows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursows.entities.Produto;
import com.lucas.cursows.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarPorId(long id) {
		Optional<Produto> objeto = produtoRepository.findById(id);
		return objeto.get();
	}
	

}
