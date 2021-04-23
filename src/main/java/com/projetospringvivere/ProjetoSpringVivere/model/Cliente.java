package com.projetospringvivere.ProjetoSpringVivere.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Cliente implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	@Column (length=30, nullable = false )
	private String nome;
	@Column(length=14, nullable=false)
	private String cpfCnpj;
	@Column(length=50, nullable=false)
	private String logradouro;
	@Column(length=40, nullable=false)
	private String  cidade;
	@Column(length=2, nullable=false)
	private String uf;
	@Column(length=8, nullable=false)
	private String cep;
	@Column(length=11, nullable=true)
	private String telefone;
	@Column(length=100, nullable=true)
	private String email;
	
	
	private LocalDate datacadastro = LocalDate.now();
	
	
	

	public Cliente() {
		
	}
	public Cliente(int id, String nome, String email, String cpfCnpj, String telefone, String logradouro, String uf,
			String cep, String cidade, LocalDate datacadastro) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.uf = uf;
		this.cep = cep;
		this.cidade = cidade;
		this.datacadastro = datacadastro;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public LocalDate getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	}


	

	

	

	
	




