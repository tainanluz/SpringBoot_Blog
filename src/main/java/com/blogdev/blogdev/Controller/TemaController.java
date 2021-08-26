package com.blogdev.blogdev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogdev.blogdev.Repository.TemaRepository;
import com.blogdev.blogdev.model.Tema;

@RestController
@RequestMapping("/api/v1/tema")

public class TemaController {
	private @Autowired TemaRepository repository;
	
	@GetMapping("/todos")
	public List<Tema> pegarTodes(){
		return repository.findAll();
	}
}
