package com.projeto.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.spring.domain.Categoria;
import com.projeto.spring.domain.Cidade;
import com.projeto.spring.domain.Cliente;
import com.projeto.spring.domain.Endereco;
import com.projeto.spring.domain.Estado;
import com.projeto.spring.domain.Produto;
import com.projeto.spring.domain.enums.TipoCliente;
import com.projeto.spring.repositories.CategoriaRepository;
import com.projeto.spring.repositories.CidadeRepository;
import com.projeto.spring.repositories.ClienteRepository;
import com.projeto.spring.repositories.EnderecoRepository;
import com.projeto.spring.repositories.EstadoRepository;
import com.projeto.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner {
	
	// dependencia para mockar os dados.
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository prodRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "Campinas", est2);
		Cidade cid3 = new Cidade(null, "São paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "Maria silva", "maria@gmail.com", "36595523160", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefone().addAll(Arrays.asList("21980745821", "21983646125"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "320", "apto 3200", "Jarim", "25221350", cli1, cid1);
		Endereco e2 = new Endereco(null, "Av. Matos", "110", "Sala 800", "Centro", "3877012", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}

}
