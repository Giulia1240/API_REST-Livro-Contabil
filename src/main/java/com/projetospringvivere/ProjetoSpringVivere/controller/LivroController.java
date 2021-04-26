package com.projetospringvivere.ProjetoSpringVivere.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetospringvivere.ProjetoSpringVivere.model.Livro;
import com.projetospringvivere.ProjetoSpringVivere.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro") 
@CrossOrigin(origins = "*")

public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping

	public List<Livro> listarLivros() {

		return livroRepository.findAll();
	}

	@GetMapping(value="/{id}")
	public Optional<Livro> listarLivroId(@PathVariable(value = "id") int id) {

		return livroRepository.findById(id);

	}
	
	@GetMapping(value="/search")
	Iterable<Livro> listarLivroQuery(@RequestParam Integer id){
		
		
		return livroRepository.findByClienteId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro salvarLivro(@RequestBody Livro livro) {

		return livroRepository.save(livro);
	}

	@PutMapping(value="/{id}")
	public Livro atualizaLivro(@RequestBody Livro livro,@PathVariable(value = "id") int id) {
		
		 return livroRepository.save(livro);
	}
	
	@DeleteMapping(value="/{id}")
	public void  deletarUsuario(@PathVariable(value = "id") int id){
		
		livroRepository.deleteById(id);
	}
	
	
	
	}


