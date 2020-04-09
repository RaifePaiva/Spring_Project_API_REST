package com.projeto.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.spring.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	

}
