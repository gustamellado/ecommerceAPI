package com.residencia.ecommerce.entities;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "produtospedidos")
public class Produtos_Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtopedidoid")
	private Integer produtopedidoid;
	
//	@ManyToOne
//	@JoinColumn(name="produto_id", referencedColumnName="produtoid")
//	private Produtos_Pedidos produtospedidos;
	
//	@ManyToOne
//	@JoinColumn(name="pedido_id", referencedColumnName="pedidoid")
//	private Produtos_Pedidos produtospedidos;
	
	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "precopedido")
	private BigDecimal precopedido;
}