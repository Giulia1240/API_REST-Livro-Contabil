package com.projetospringvivere.ProjetoSpringVivere.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length=30, nullable=false)
	private String nome;
	@Column(length=15, nullable=false)
	private String login;
	@Column(length=10, nullable=false)
	private String senha;
	@Column(length=11, nullable=true)
	private String telefone;
	@Column(length=100, nullable=true)
	private String email;
	
	
	@Column(nullable = false)
	private LocalDate datacadastro = LocalDate.now();
	
	@Column(length=1, nullable=false)
	private String perfil;
	@Column(length=1, nullable=false)
	private String status;

	public Usuario() {

	}

	public Usuario(int id, String nome, String email, String telefone, String login, String senha,
			LocalDate datacadastro, String perfil, String status) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.datacadastro = datacadastro;
		this.perfil = perfil;
		this.status = status;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
