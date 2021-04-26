package com.projetospringvivere.ProjetoSpringVivere.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetospringvivere.ProjetoSpringVivere.model.Cliente;
import com.projetospringvivere.ProjetoSpringVivere.repository.ClienteRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")

public class ClienteController {

	@Autowired

	private ClienteRepository clienteRepository;

	@GetMapping
	@Column(nullable=false)
	public List<Cliente> listarCliente() {

		return clienteRepository.findAll();

	}

	@GetMapping(value = "/{id}")
	public Optional<Cliente> listarClienteId(@PathVariable(value = "id") int id) {

		return clienteRepository.findById(id);

	}

	@GetMapping(value = "/search")
	List<Cliente> listarClienteQuery(@RequestParam("nome") String nome, @RequestParam("cpfnpj") String cpfCnpj,
			@RequestParam("cidade") String cidade, @RequestParam("uf") String uf) {

		if (!nome.equals("") && !cpfCnpj.equals("") && !cidade.equals("") && !uf.equals("")) {

			return clienteRepository.findByNomeContainingAndCpfCnpjContainingAndCidadeAndUfContaining(nome, cpfCnpj,
					cidade, uf);

		} else if (!nome.equals("")) {

			return clienteRepository.findByNomeContaining(nome);
		}

		else if (!cpfCnpj.equals("")) {

			return clienteRepository.findByCpfCnpjContaining(cpfCnpj);
		}

		else if (!cidade.equals("")) {

			return clienteRepository.findByCidadeContaining(cidade);
		} else if (!uf.equals("")) {

			return clienteRepository.findByUfContaining(uf);
		}

		else {

			return clienteRepository.findAll();
		}

	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> verificarCliente(@RequestBody Cliente cliente) {
		
		String cpfCnpj = cliente.getCpfCnpj();

		List<Cliente> verifica = clienteRepository.findByCpfCnpjContaining(cpfCnpj);

		if (verifica.size() > 0) {

			return ResponseEntity.ok().body("Cliente já cadastrado");
		} else {

			clienteRepository.save(cliente);
			return ResponseEntity.ok().body("Cliente foi cadastrado com sucesso");
		}

	}

	@DeleteMapping(value = "/{id}")
	public void deletarCliente(@PathVariable(value = "id") int id) {

		clienteRepository.deleteById(id);
	}

	@PutMapping(value = "/{id}")
	public Cliente atualizaCliente(@RequestBody Cliente cliente, @PathVariable(value = "id") int id) {

		return clienteRepository.save(cliente);
	}

}
