package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "produto")

public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtoid")
	private Integer produtoid;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "precoproduto")
	private BigDecimal precoproduto;
	
	@Column(name = "quantidadeestoque")
	private Integer quantidadeestoque;

	@Column(name = "datacadastroproduto")
	private Calendar datacadastroproduto;
	
//	@Column(name = "imagem")
//	private Calendar imagem;
	
//	@ManyToOne
//	@JoinColumn(name="categoria_id", referencedColumnName="categoriaid")
//	private Categoria categoria_id;
}

	
