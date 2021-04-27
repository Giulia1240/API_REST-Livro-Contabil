package com.projetospringvivere.ProjetoSpringVivere.repository;

import java.time.LocalDate;
import java.util.List;

//import java.time.LocalDate;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query(value = "select l from Livro l where l.cliente.id = ?1 and l.dataLancamento between ?2 and ?3 ")
	List<Livro> findByContabil(int cliente, LocalDate dataLancamentoUm, LocalDate dataLancamentoDois);
	
	@Query(value = "select l from Livro l where l.cliente.id = ?1 ")
	List<Livro> findByContabil(int cliente);
	
	List<Livro> findByClienteId(int id);
	

	

}
