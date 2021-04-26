package com.projetospringvivere.ProjetoSpringVivere.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
	@Query(value="select c from Cliente c where c.nome = ?1" )
	List<Cliente> findByNomeContaining(String nome);
	
	@Query(value="select c from Cliente c where c.cpfCnpj = ?1 ")
	List<Cliente> findByCpfCnpjContaining(String cpfCnpj);
	
	@Query(value="select c from Cliente c where c.cidade = ?1")
	List<Cliente> findByCidadeContaining(String cidade);
	
	@Query(value="select c from Cliente c where c.uf = ?1")
	List<Cliente> findByUfContaining(String uf);
	
	@Query(value="select c from Cliente c where c.nome = ?1 and c.cpfCnpj= ?2 and c.cidade=?3 and c.uf=?4")
	List<Cliente> findByNomeContainingAndCpfCnpjContainingAndCidadeAndUfContaining(String nome, String cpfCnpj,
			String cidade, String uf);



}
