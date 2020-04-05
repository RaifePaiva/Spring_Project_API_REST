package com.projeto.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.spring.domain.Categoria;
import com.projeto.spring.repositories.CategoriaRepository;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	
	// dependencia para mockar os dados.
	@Autowired
	private CategoriaRepository categoriaRepository;
	////////

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Intanciando objetos para testes (Mockando).
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
