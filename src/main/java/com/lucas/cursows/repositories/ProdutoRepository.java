package com.lucas.cursows.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.cursows.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
