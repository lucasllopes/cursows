package com.lucas.cursows.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucas.cursows.entities.Categoria;
import com.lucas.cursows.entities.ItemPedido;
import com.lucas.cursows.entities.Pagamento;
import com.lucas.cursows.entities.Pedido;
import com.lucas.cursows.entities.Produto;
import com.lucas.cursows.entities.Usuario;
import com.lucas.cursows.entities.enums.StatusPedido;
import com.lucas.cursows.repositories.CategoriaRepository;
import com.lucas.cursows.repositories.ItemPedidoRepository;
import com.lucas.cursows.repositories.PedidoRepository;
import com.lucas.cursows.repositories.ProdutoRepository;
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
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(0l, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(0l, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.PAGO, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		
		pedidoRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null,"Books");
		Categoria cat3 = new Categoria(null, "Computers");
		
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat3);
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);		
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		ItemPedido ip1 = new ItemPedido(o1, p1, 2, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(o1, p3, 1, p3.getPreco());
		ItemPedido ip3 = new ItemPedido(o2, p3, 2, p3.getPreco());
		ItemPedido ip4 = new ItemPedido(o3, p5, 2, p5.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
		
		Pagamento pg1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPagamento(pg1); 		
		pedidoRepository.save(o1); // nao e necessario criar um repository para classes dependentes e
									 //que estao numa relacao 1 para 1, e possivel associar o objeto dependente ao objeto independente 
									 // e utilizar seu repository para persistir os dados
	}
	
	

}
