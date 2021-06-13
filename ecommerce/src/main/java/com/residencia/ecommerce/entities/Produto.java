package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtoid")
	private Integer produtoId;

	@Column(name = "nome",unique = true)
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@NotNull(message="Coloque o preço do produto!")
    @DecimalMax(value="10000",  message= " Não ultrapasse o valor de R$ {value}!")
    @DecimalMin(value="1",  message= " Não insira preço menor que R$ {value}!")
	@Column(name = "precoproduto")
	private BigDecimal precoProduto;

	@NotNull(message="Insira a quantidade disponível!")
	@Column(name = "quantidadeestoque")
	private Integer quantidadeEstoque;

	@CreationTimestamp
	@Column(name = "datadecadastrodoproduto")
	private LocalDateTime dataDeCadastroDoProduto;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "categoriaid", referencedColumnName = "categoriaid")
	private Categoria categoria;

	@OneToOne(mappedBy = "produtos")
	@JsonIgnore
	private ProdutosPedidos produtoPedido;
	
	@Column(name="imagem")
	private String imagem;

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
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

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public LocalDateTime getDataDeCadastroDoProduto() {
		return dataDeCadastroDoProduto;
	}

	public void setDataDeCadastroDoProduto(LocalDateTime dataDeCadastroDoProduto) {
		this.dataDeCadastroDoProduto = dataDeCadastroDoProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ProdutosPedidos getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutosPedidos produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	
	
}

	
