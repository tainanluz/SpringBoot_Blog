package com.blogdev.blogdev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogdev.blogdev.Repository.PostagemRepository;
import com.blogdev.blogdev.model.Postagem;

@RestController
@RequestMapping("/api/v1/postagem")
public class PostagemController {
	private @Autowired PostagemRepository repository;
	
	@GetMapping("/todas")
	public List<Postagem> pegarTodes(){
		return repository.findAll();
		
	}
	

}
