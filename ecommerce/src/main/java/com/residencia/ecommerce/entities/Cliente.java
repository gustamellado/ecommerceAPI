package com.residencia.ecommerce.entities;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientid ")
	private Integer clientId;

	@NotBlank (message= "Email obrigatorio!")
    @Email(message= "E-mail inserido de forma incorreta!")
    @Pattern(regexp=".+@.+\\..+", message="E-mail inserido de forma incorreta!")
	@Column(name = "email")
	private String email;

	@NotBlank(message= "Username é obrigatório!")
    @Size(max = 15, message= "Username pode ter até {max} caracteres!")
    @Size(min = 5, message= "Username tem que ter no mínimo {min} caracteres!")
	@Column(name = "username", unique=true)
	private String username;

	@NotBlank(message= "Insira sua senha!")
	@Column(name = "senha")
	private String senha;

	@NotBlank  (message="Insira seu nome!")
	@Column(name = "nome")
	private String nome;

	@NotBlank  (message="Insira seu cpf!")
	@Column(name = "cpf", unique = true)
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "datadenascimento")
	private Calendar dataDeNascimento;

	@ManyToOne
	@JoinColumn(name = "enderecoid", referencedColumnName = "enderecoid")
	@JsonBackReference
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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