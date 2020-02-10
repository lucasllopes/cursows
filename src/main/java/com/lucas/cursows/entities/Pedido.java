package com.lucas.cursows.entities;

import java.time.Instant;

import javax.persistence.Entity;

@Entity
public class Pedido {
	
	private Long id;
	private Instant momentoPedido;
	
	private Usuario cliente;

}
