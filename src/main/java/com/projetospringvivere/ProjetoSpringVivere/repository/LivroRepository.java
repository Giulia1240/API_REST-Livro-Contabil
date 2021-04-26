package com.projetospringvivere.ProjetoSpringVivere.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Livro;


@Repository
public interface LivroRepository extends JpaRepository<Livro ,Integer>{
	
	@Query(value="select l from Livro l where l.id = ?1 ")
	Iterable<Livro> findByClienteId( int cliente);
	
	
	

}
