package com.blogdev.blogdev.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogdev.blogdev.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long>{
	
	//Método utilizado para pesquisar coluna titulo ContainigIgnoreCase
	List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

}
