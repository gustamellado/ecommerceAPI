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

	@Column(name = "valortotaldopedido")
	private BigDecimal valorTotalDoPedido;

	@Column(name = "datadopedido")
	private Calendar dataDoPedido;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "clientid", referencedColumnName = "clientid")
	private Cliente clienteid;

	@OneToOne(mappedBy = "pedido")
	private Produtos_Pedidos produtoPedido;

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

	public BigDecimal getValorTotalDoPedido() {
		return valorTotalDoPedido;
	}

	public void setValorTotalDoPedido(BigDecimal valorTotalDoPedido) {
		this.valorTotalDoPedido = valorTotalDoPedido;
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

	public Cliente getClienteid() {
		return clienteid;
	}

	public void setClienteid(Cliente clienteid) {
		this.clienteid = clienteid;
	}

	public Produtos_Pedidos getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(Produtos_Pedidos produtoPedido) {
		this.produtoPedido = produtoPedido;
	}
}

