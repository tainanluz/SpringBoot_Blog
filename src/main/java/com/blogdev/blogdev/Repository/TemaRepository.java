package com.blogdev.blogdev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogdev.blogdev.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>{

}
