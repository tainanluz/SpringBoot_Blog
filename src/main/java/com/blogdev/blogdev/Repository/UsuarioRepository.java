package com.blogdev.blogdev.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogdev.blogdev.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	// Método utilizado para pesquisar coluna nome ContainigIgnoreCase
	List<Usuario> findAllByNome(String nome);
	
	//Método utilizado para pesquisar coluna email
	Optional<Usuario> findByEmail(String email);
	

}
