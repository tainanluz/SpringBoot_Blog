package com.blogdev.blogdev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogdev.blogdev.Repository.UsuarioRepository;
import com.blogdev.blogdev.model.Usuario;

@RestController
@RequestMapping("/api/v1/usuario")

public class UsuarioController {
	private @Autowired UsuarioRepository repository;
	
	@GetMapping("/todes")
	public List<Usuario> pegarTodes(){
		return repository.findAll();
	}

}
