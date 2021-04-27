package com.projetospringvivere.ProjetoSpringVivere.controller;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetospringvivere.ProjetoSpringVivere.dto.LivroDto;
import com.projetospringvivere.ProjetoSpringVivere.dto.RelatorioDto;
//import com.projetospringvivere.ProjetoSpringVivere.dto.LivroDto;
//import com.projetospringvivere.ProjetoSpringVivere.dto.RelatorioDto;
import com.projetospringvivere.ProjetoSpringVivere.model.Livro;
import com.projetospringvivere.ProjetoSpringVivere.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livro")
@CrossOrigin(origins = "*")

public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@PostMapping(value = "/inserir")
	@ResponseStatus(HttpStatus.CREATED)
	public Livro salvarLivro(@RequestBody Livro livro) {

		return livroRepository.save(livro);
	}

	@GetMapping

	public List<Livro> listarLivros() {

		return livroRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Livro> listarLivroId(@PathVariable(value = "id") int id) {

		return livroRepository.findById(id);

	}

	@GetMapping(value = "/id_cliente")
	Iterable<Livro> findByQuery(@RequestParam(value = "cliente") int cliente) {

		return livroRepository.findByClienteId(cliente);
	}

	@GetMapping(value = "/search")
	Iterable<Livro> listarLivroQuery(@RequestParam Integer id) {

		return livroRepository.findByClienteId(id);
	}

	@GetMapping(value = "/relatorio")
	public ResponseEntity<LivroDto> verficaDebitoOuCredito(@RequestParam(value = "cliente") int cliente,
			@RequestParam("data_ini") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate dataLancamentoUm,
			@RequestParam("data_fim") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDate dataLancamentoDois,
			@RequestParam float saldo) {

		List<Livro> obj = livroRepository.findByContabil(cliente, dataLancamentoUm, dataLancamentoDois);
		ArrayList<RelatorioDto> result = new ArrayList<RelatorioDto>();
		float valor = 0, resultado = 0;
		LivroDto infoCliente = null;
		if (obj.size() > 0) {

			// Valor inicial = saldo
			// No for abaixo o resultado vai sendo modificado de acordo com os lancamentos
			resultado = saldo;
			for (Livro item : obj) {
				valor = item.getValor();

				if (item.getTipo().equals("C")) {
					resultado = resultado + valor;
				}

				else if (item.getTipo().equals("D")) {
					resultado = resultado - valor;

				}

				// Adicionando informacoes dos lancamentos no ArrayList do tipo RelatorioDTO
				result.add(new RelatorioDto(item.getDataLancamento(), item.getDescricao(), item.getTipo(),
						item.getValor(), resultado));

			}
			// Objeto contendo as informações finais (Cliente + result = ArrayList do tipo
			// RelatorioDTO)
			infoCliente = new LivroDto(obj.get(0).getCliente().getId(), obj.get(0).getCliente().getCpfCnpj(),
					obj.get(0).getCliente().getNome(), obj.get(0).getCliente().getTelefone(), result);
		}
		return new ResponseEntity<LivroDto>(infoCliente, HttpStatus.OK);

	}

	@PutMapping(value = "/{id}")
	public Livro atualizaLivro(@RequestBody Livro livro, @PathVariable(value = "id") int id) {

		return livroRepository.save(livro);
	}

	@DeleteMapping(value = "/{id}")
	public void deletarUsuario(@PathVariable(value = "id") int id) {

		livroRepository.deleteById(id);
	}

}
