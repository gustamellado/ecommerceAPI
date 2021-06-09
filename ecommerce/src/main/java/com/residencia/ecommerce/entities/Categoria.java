package com.residencia.ecommerce.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoriaid")
	private Integer categoriaId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	//relacionamento com produto
	@OneToMany(mappedBy = "categoria")
	private List<Produtos> listProdutos;

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
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

	public List<Produtos> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<Produtos> listProdutos) {
		this.listProdutos = listProdutos;
	}
}
