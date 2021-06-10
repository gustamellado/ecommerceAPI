package com.residencia.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "produtospedidos")
public class ProdutosPedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtopedidoid")
	private Integer produtoPedidoId;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
	private Integer preco;

	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "produtoid", referencedColumnName = "produtoid")
	private Produto produtos;

	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "pedidoid", referencedColumnName = "pedidoid")
	private Pedidos pedido;

	public Integer getProdutoPedidoId() {
		return produtoPedidoId;
	}

	public void setProdutoPedidoId(Integer produtoPedidoId) {
		this.produtoPedidoId = produtoPedidoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}
}