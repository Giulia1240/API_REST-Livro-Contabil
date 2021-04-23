package com.projetospringvivere.ProjetoSpringVivere.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
	
	List<Cliente> findByNomeContaining(String nome);
	List<Cliente> findByCpfCnpjContaining( String cpfCnpj);
	List<Cliente> findByCidadeContaining(String cidade);
	List<Cliente> findByUfContaining(String uf);
	List<Cliente> findByNomeContainingAndCpfCnpjContainingAndCidadeAndUfContaining(String nome, String cpfCnpj,
			String cidade, String uf);



}
