package com.residencia.ecommerce.vo;

import java.util.Calendar;

import javax.validation.constraints.*;

import com.residencia.ecommerce.entities.Endereco;

public class CadastroClienteVO {

	@NotBlank(message = "insira um cep valido")
	private String cep;

	private String complemento;
	private String numero;
	
	@NotBlank(message="Insira seu nome!")
	private String nome;
	
	@NotBlank(message= "Username é obrigatório!")
    @Size(max = 15, message= "Username pode ter até {max} caracteres!")
    @Size(min = 5, message= "Username tem que ter no mínimo {min} caracteres!")
	private String username;
	
	@NotBlank(message= "Insira sua senha!")
	private String senha;
	
	@NotBlank  (message="Insira seu cpf!")
	private String cpf;
	private String telefone;
	private Calendar dataNascimento;
	private Endereco endereco;
	
	@NotBlank (message= "Email obrigatorio!")
    @Pattern(regexp=".+@.+\\..+", message="E-mail inserido de forma incorreta!")
	private String email;
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
