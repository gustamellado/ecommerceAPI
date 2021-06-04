package com.residencia.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "editora")
public class Endereco {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enderecoid")
	private Integer enderecoid;
	
//	@OneToMany(mappedBy = "endereco_id")
//	private Cliente cliente;
	
	@Column(name = "cep")
	private Integer cep;
	
	@Column(name = "rua")
	private String rua;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "estado")
	private String estado;

	public Integer getEnderecoid() {
		return enderecoid;
	}

	public void setEnderecoid(Integer enderecoid) {
		this.enderecoid = enderecoid;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
