package com.projetospringvivere.ProjetoSpringVivere.dto;

import java.time.LocalDate;

public class RelatorioDto {
	private LocalDate dataLancamento;
	private String descricao;
	private String tipo;
	private double valor;
	private double saldo;
	
	
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	public RelatorioDto() {
	
	}
	public RelatorioDto(LocalDate dataLancamento, String descricao, String tipo, double valor, double saldo) {
		
		this.dataLancamento = dataLancamento;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valor = valor;
		this.saldo = saldo;
	}
	

}
