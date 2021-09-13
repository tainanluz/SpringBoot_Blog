package com.blogdev.blogdev.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogdev.blogdev.Repository.UsuarioRepository;
import com.blogdev.blogdev.Service.UsuarioService;
import com.blogdev.blogdev.model.Usuario;
import com.blogdev.blogdev.model.Util.UsuarioDTO;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
	private @Autowired UsuarioRepository repository;
	private @Autowired UsuarioService service;

	@GetMapping("/todos")
	public ResponseEntity<List<Usuario>> pegarTodos() {
		List<Usuario> objetoLista = repository.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objetoOptional = service.cadastrarUsuario(novoUsuario);

		if (objetoOptional.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoOptional.get());
		}
	}

	@PutMapping("/credenciais")
	public ResponseEntity<Object> credenciais(@Valid @RequestBody UsuarioDTO usuarioParaAutenticar) {
		Optional<?> objetoOptional = service.pegarCredenciais(usuarioParaAutenticar);

		if (objetoOptional.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoOptional.get());
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<Usuario> objetoUsuario = repository.findById(idUsuario);

		if (objetoUsuario.isPresent()) {
			return ResponseEntity.status(200).body(objetoUsuario.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/nome/{nome_usuario}")
	public ResponseEntity<List<Usuario>> buscarPorNomeI(@PathVariable(value = "nome_usuario") String nome) {
		List<Usuario> objetoLista = repository.findAllByNome(nome);

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Usuario>> buscarPorNomeII(@RequestParam(defaultValue = "") String nome) {
		List<Usuario> objetoLista = repository.findAllByNome(nome);

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuarioParaAtualizar) {
		return ResponseEntity.status(201).body(repository.save(usuarioParaAtualizar));
	}
  
	@PutMapping("/alterar")
	public ResponseEntity<Object> alterar(@Valid @RequestBody UsuarioDTO usuarioParaAlterar) {
		Optional<?> objetoAlterado = service.alterarUsuario(usuarioParaAlterar);

		if (objetoAlterado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAlterado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<Object> deletarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<Usuario> objetoOptional = repository.findById(idUsuario);
		if (objetoOptional.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			repository.deleteById(idUsuario);
			return ResponseEntity.status(200).build();
		}
	}


}
