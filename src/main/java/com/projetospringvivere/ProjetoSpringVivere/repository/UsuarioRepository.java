package com.projetospringvivere.ProjetoSpringVivere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario ,Integer> {
	
	Usuario findByLoginAndSenha(String login, String senha);
	Usuario findByPerfilContaining(String perfil);
	
   @Query(value="select u from Usuario u where u.email = ?1 ")
	Iterable<Usuario> findByEmailContaining(String email);
	
    @Query(value="select u from Usuario u where u.nome = ?1 ")
	Iterable<Usuario> findByNomeContaining(String nome);
    
    @Query(value="select u from Usuario u where u.nome = ?1 and u.email= ?2")
	Iterable<Usuario> findByNomeContainingAndEmailContaining(String nome, String email);
	
	
	
	
}
