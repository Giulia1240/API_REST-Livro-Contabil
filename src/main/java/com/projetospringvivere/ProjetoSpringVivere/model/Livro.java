package com.projetospringvivere.ProjetoSpringVivere.model;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;







@Entity
public class Livro implements Serializable{
	
private static final long serialVersionUID=(long) 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	
	private int id;
	@Column(length=50, nullable=false)
	private String descricao;
	@Column(length=12, nullable=false)
	private float valor;
	
	//@Type(type="String")
    @Column(length=1, nullable=false)
	private String tipo ;
    
    
    
	@ManyToOne
	@JoinColumn(name= "id_cliente", nullable=false) 
	private Cliente cliente;
	
	private LocalDate dataLancamento = LocalDate.now();
	
	
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	

	
	public Livro() {
		
	}
	
	public Livro(int id, String descricao, float valor, LocalDate dataLancamento, String tipo, Cliente cliente) {
		
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataLancamento = dataLancamento;
		this.tipo = tipo;
		this.cliente = cliente;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
