package com.lucas.cursows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.cursows.entities.Pedido;
import com.lucas.cursows.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> buscarTodos(){
		return pedidoRepository.findAll();
	}
	
	public Pedido buscarPorId(long id) {
		Optional<Pedido> objeto = pedidoRepository.findById(id);
		return objeto.get();
	}

}
