package com.blogdev.blogdev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogdev.blogdev.Repository.PostagemRepository;
import com.blogdev.blogdev.model.Postagem;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	private @Autowired PostagemRepository repository;
		
	@GetMapping("/todas")
	public List<Postagem> pegarTodas()
	{
		return repository.findAll();		
	}
}
