package com.residencia.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoriaid")
	private Integer categoriaid;
	
//	@OneToMany(mappedBy = "categoria_id")
//	private Produto produto;
	
	@Column(name = "nomecategoria")
	private String nomecategoria;	
	
	@Column(name = "descricaocategoria")
	private String descricaocategoria;
	
}
