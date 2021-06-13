package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedidos")
public class Pedidos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedidoid")
	private Integer pedidosId;

	@Column(name = "numerodopedido")
	private Integer numeroDoPedido;

	@NotNull(message="Insira o valor do pedido!")
	@DecimalMin(value="1",  message= " O valor mínimo é de R$ {value}!")
	@Column(name = "valorpedido")
	private BigDecimal valorPedido;

	@Column(name = "datadopedido")
	private Calendar dataDoPedido;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "clientid", referencedColumnName = "clientid")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido")
	@JsonIgnore
	private List<ProdutosPedidos> listProdutoPedido;

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

	public List<ProdutosPedidos> getListProdutoPedido() {
		return listProdutoPedido;
	}

	public void setListProdutoPedido(List<ProdutosPedidos> listProdutoPedido) {
		this.listProdutoPedido = listProdutoPedido;
	}

	
}

