package com.lucas.cursows.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucas.cursows.entities.Categoria;
import com.lucas.cursows.entities.Pedido;
import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.entities.enums.StatusPedido;
import com.lucas.cursows.repositories.CategoriaRepository;
import com.lucas.cursows.repositories.PedidoRepository;
import com.lucas.cursows.repositories.UsuarioRepository;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(0, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(0, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		
		Pedido o1 = new Pedido(0l, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.PAGO, u1);
		Pedido o2 = new Pedido(0l, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(0l, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		Categoria cat1 = new Categoria(0l, "Electronics");
		Categoria cat2 = new Categoria(0l,"Books");
		Categoria cat3 = new Categoria(0l, "Computers");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
	}
	
	

}
