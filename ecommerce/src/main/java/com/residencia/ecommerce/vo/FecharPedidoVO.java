package com.residencia.ecommerce.vo;

import java.math.BigDecimal;
import java.util.List;

public class FecharPedidoVO {
	private Integer pedidoId;
	private String clienteEmail;
	private List<ProdutoQtdVO> listProdutoQtd;
	private float valorCompra;
	
	
	public Integer getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}
	public String getClienteEmail() {
		return clienteEmail;
	}
	public void setClienteEmail(String clienteEmail) {
		this.clienteEmail = clienteEmail;
	}
	
	public List<ProdutoQtdVO> getListProdutoQtd() {
		return listProdutoQtd;
	}
	public void setListProdutoQtd(List<ProdutoQtdVO> listProdutoQtd) {
		this.listProdutoQtd = listProdutoQtd;
	}
	public float getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
	
}
