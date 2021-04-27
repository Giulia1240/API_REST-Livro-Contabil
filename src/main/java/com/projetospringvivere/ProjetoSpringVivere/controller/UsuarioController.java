package com.projetospringvivere.ProjetoSpringVivere.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
*/
import com.projetospringvivere.ProjetoSpringVivere.model.Usuario;
import com.projetospringvivere.ProjetoSpringVivere.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")

public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listarUsuario() {

		return usuarioRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Usuario> listarUsuarioId(@PathVariable(value = "id") int id) {

		return usuarioRepository.findById(id);

	}

	@GetMapping(value = "/search")
	public Iterable<Usuario> listarUsuarioQuery(@RequestParam String nome, @RequestParam String email) {

		if (!nome.equals("") && !email.equals("")) {

			return usuarioRepository.findByNomeContainingAndEmailContaining(nome, email);

		} else if (!email.equals("")) {

			return usuarioRepository.findByEmailContaining(email);
		} else if (!nome.equals("")) {

			return usuarioRepository.findByNomeContaining(nome);
		}

		else {

			return usuarioRepository.findAll();
		}
	}

	@GetMapping("/perfil")
	public ResponseEntity<String> verificarPerfil(@RequestParam String perfil) {

		Usuario perfilUsuario = usuarioRepository.findByPerfilContaining(perfil);

		if (perfilUsuario == null) {

			return ResponseEntity.notFound().build();
		} else if (perfilUsuario.getStatus().equals("A")) {

			return ResponseEntity.ok().body("Administrador");
		}

		else if (perfilUsuario.getStatus().equals("O")) {

			return ResponseEntity.ok().body("Operador");
		}

		else {

			return ResponseEntity.ok().body("Inativo ou não consta");
		}

	}

	@GetMapping("/login")
	public ResponseEntity<String> verificarLoginESenhas(@RequestParam String login, @RequestParam String senha) {

		Usuario status = usuarioRepository.findByLoginAndSenha(login, senha);

		if (status == null) {

			return ResponseEntity.ok().body("Usuario não encontrado");
		}

		else if (status.getStatus().equals("C")) {

			return ResponseEntity.ok().body("Usuario cancelado no sistema");

		} else {

			return ResponseEntity.ok().body("Usuario Logado com sucesso");
		}

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

	@PutMapping(value = "/{id}")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable(value = "id") int id) {

		usuario.setId(id);
		
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable(value = "id") int id) {

		usuarioRepository.deleteById(id);
	}

}
