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

	@Column(name = "nomecategoria")
	private String nomeCategoria;

	@Column(name = "descricaocategoria")
	private String descricaoCategoria;

	//relacionamento com produto
	@OneToMany(mappedBy = "categoria")
	private List<Produto> listProdutos;

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public List<Produto> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<Produto> listProdutos) {
		this.listProdutos = listProdutos;
	}
}
