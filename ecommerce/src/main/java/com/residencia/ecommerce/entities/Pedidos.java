package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedidoid")
	private Integer pedidoid;
	
//	@OneToMany(mappedBy = "cliente_id")
//	private Produtos_Pedidos produtospedidos;
	
	@Column(name = "numerodopedido")
	private Integer numerodopedido;

//	@Column(name = "listapedidos")
//	private List<>
	
	@Column(name = "valortotal")
	private BigDecimal valortotal;
	
	@Column(name = "datadopedido")
	private Calendar datadopedido;
	
//	@Column(name = "datadopedido")
//	private Calendar datadopedido;

	@Column(name = "status")
	private String status;
	
//	@ManyToOne
//	@JoinColumn(name="cliente_id", referencedColumnName="clienteid")
//	private Cliente cliente_id;

}

