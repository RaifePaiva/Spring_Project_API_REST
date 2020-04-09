package com.projeto.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.spring.domain.Categoria;
import com.projeto.spring.domain.Produto;
import com.projeto.spring.repositories.CategoriaRepository;
import com.projeto.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	
	// dependencia para mockar os dados.
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository prodRepository;
	////////

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Intanciando objetos para testes (Mockando).
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		prodRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
