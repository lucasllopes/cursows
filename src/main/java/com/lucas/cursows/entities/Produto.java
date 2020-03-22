package com.lucas.cursows.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;

    @ManyToMany
    @JoinTable(name = "produto_categoria", // criando tabela associativa
    joinColumns = @JoinColumn(name = "id_produto", nullable = false ), // id da tabela produto
    inverseJoinColumns = @JoinColumn(name = "id_categoria", nullable = false) // id da tabela categoria
    ) private Set<Categoria> categorias = new HashSet<>();

    
    @OneToMany(mappedBy = "id.produto")
   /* Mesma ideia do mapeamento da classe pedido em relacao a classe ItemPedido
    * porem, a  classe produto utiliza a classe itemPedido para retornar os pedidos em si,e nao os itemPedido.
    * Essa particularidade e identificada no metodo getPedidos dessa classe.
    */
    private Set<ItemPedido> itens = new HashSet<>(); 
    
	public Produto() {
		
	}

	public Produto(Long id, String nome, String descricao, Double preco, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}	

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
    @JsonIgnore
	public Set<Pedido> getPedidos(){
		Set<Pedido> set = new HashSet<>();
		for(ItemPedido p:itens) {
			set.add(p.getPedido());
		}
		return set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	



	
	
	
	
	
	

}
