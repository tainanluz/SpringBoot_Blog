package com.blogdev.blogdev.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogdev.blogdev.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>{
	
	// Método utilizado para pesquisar coluna tema ContainigIgnoreCase
	List<Tema> findAllByTemaContainingIgnoreCase(String tema);
}
