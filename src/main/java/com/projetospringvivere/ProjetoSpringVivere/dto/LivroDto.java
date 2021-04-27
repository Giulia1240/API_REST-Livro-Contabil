package com.projetospringvivere.ProjetoSpringVivere.dto;


import java.util.List;



public class LivroDto {
	private int id;
	private String nome;
	private String cpf_cnpj;
	private String telefone;
	private List<RelatorioDto> cont;

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

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<RelatorioDto> getCont() {
		return cont;
	}

	public void setCont(List<RelatorioDto> cont) {
		this.cont = cont;
	}

	public LivroDto(int id, String nome, String cpf_cnpj, String telefone, List<RelatorioDto> cont) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone = telefone;
		this.cont = cont;
	}

	public LivroDto() {

	}

}
