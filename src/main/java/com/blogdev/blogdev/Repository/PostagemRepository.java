package com.blogdev.blogdev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogdev.blogdev.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long>{

}
