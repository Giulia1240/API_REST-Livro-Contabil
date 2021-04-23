package com.projetospringvivere.ProjetoSpringVivere.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Livro;


@Repository
public interface LivroRepository extends JpaRepository<Livro ,Integer>{
	

	Iterable<Livro> findByClienteId( int id);
	
	
	

}
