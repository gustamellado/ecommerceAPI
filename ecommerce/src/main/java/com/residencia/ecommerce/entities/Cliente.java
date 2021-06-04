package com.residencia.ecommerce.entities;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clienteid")
	private Integer clienteid;
		
//	@OneToMany(mappedBy = "cliente_id")
//	private Pedidos pedidos;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private Integer cpf;
	
	@Column(name = "telefone")
	private Integer telefone;
	
	@Column(name = "datadenascimento")
	private Calendar datadenascimento;
	
//	@ManyToOne
//	@JoinColumn(name="endereco_id", referencedColumnName="enderecoid")
//	private Endereco endereco_id;
	
	public Integer getClienteid() {
		return clienteid;
	}

	public void setClienteid(Integer clienteid) {
		this.clienteid = clienteid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Calendar getDatadenascimento() {
		return datadenascimento;
	}

	public void setDatadenascimento(Calendar datadenascimento) {
		this.datadenascimento = datadenascimento;
	}
	

	
	
	
}