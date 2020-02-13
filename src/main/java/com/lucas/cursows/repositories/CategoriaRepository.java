package com.lucas.cursows.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.cursows.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
	

}
