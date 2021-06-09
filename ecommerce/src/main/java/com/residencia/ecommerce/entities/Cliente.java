package com.residencia.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientid ")
	private Integer clientId;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf", unique = true)
	private Integer cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "datadenascimento")
	private Calendar dataDeNascimento;

	@ManyToOne
	@JoinColumn(name = "enderecoid", referencedColumnName = "enderecoid")
	@JsonManagedReference
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente")
	@JsonBackReference
	private List<Pedidos> listPedido;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pedidos> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedidos> listPedido) {
		this.listPedido = listPedido;
	}
}