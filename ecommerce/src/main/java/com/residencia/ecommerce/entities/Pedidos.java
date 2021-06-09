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
	private Integer pedidosId;

	@Column(name = "numerodopedido")
	private Integer numeroDoPedido;

	@Column(name = "listadeprodutosdopedido")
	private Integer listaDeProdutosDoPedido;

	@Column(name = "valorpedido")
	private BigDecimal valorPedido;

	@Column(name = "datadopedido")
	private Calendar dataDoPedido;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "clientid", referencedColumnName = "clientid")
	private Cliente cliente;

	@OneToOne(mappedBy = "pedido")
	private ProdutosPedidos produtoPedido;

	public Integer getPedidosId() {
		return pedidosId;
	}

	public void setPedidosId(Integer pedidosId) {
		this.pedidosId = pedidosId;
	}

	public Integer getNumeroDoPedido() {
		return numeroDoPedido;
	}

	public void setNumeroDoPedido(Integer numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}

	public Integer getListaDeProdutosDoPedido() {
		return listaDeProdutosDoPedido;
	}

	public void setListaDeProdutosDoPedido(Integer listaDeProdutosDoPedido) {
		this.listaDeProdutosDoPedido = listaDeProdutosDoPedido;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Calendar getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(Calendar dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ProdutosPedidos getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutosPedidos produtoPedido) {
		this.produtoPedido = produtoPedido;
	}
}

