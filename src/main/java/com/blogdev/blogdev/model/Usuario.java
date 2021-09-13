package com.blogdev.blogdev.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Usuario {
	private  @Id @GeneratedValue (strategy = GenerationType.IDENTITY)Long idUsuario;
	private @NotBlank String nome;
	private @NotBlank @Email String email;
	private @NotBlank String senha;
	
	@OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"criador"})
	private List<Postagem> minhasPostagens = new ArrayList<>();

public Long getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(Long idUsuario) {
	this.idUsuario = idUsuario;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public List<Postagem> getMinhasPostagens() {
	return minhasPostagens;
}
public void setMinhasPostagens(List<Postagem> minhasPostagens) {
	this.minhasPostagens = minhasPostagens;
}


}
