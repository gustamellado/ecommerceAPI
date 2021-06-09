package com.residencia.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "produtos_pedidos")
public class Produtos_Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtoPedidoid")
	private Integer produtoPedidoId;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
	private Integer preco;

	@OneToOne
	@JoinColumn(name = "produtoid", referencedColumnName = "produtoid")
	private Produtos produtos;

	@OneToOne
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

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}
}