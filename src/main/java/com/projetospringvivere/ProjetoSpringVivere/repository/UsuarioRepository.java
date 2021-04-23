package com.projetospringvivere.ProjetoSpringVivere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetospringvivere.ProjetoSpringVivere.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario ,Integer> {


	Iterable<Usuario> findByEmailContaining(String email);
	Iterable<Usuario> findByNomeContaining(String nome);
	Iterable<Usuario> findByNomeContainingAndEmailContaining(String nome, String email);
	Usuario findByLoginAndSenha(String login, String senha);
	Usuario findByPerfilContaining(String perfil);
	
	
}
