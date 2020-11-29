package dev.devlopes.shopping;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.devlopes.shopping.domain.Categoria;
import dev.devlopes.shopping.domain.Produto;
import dev.devlopes.shopping.repositories.CategoriaRepository;
import dev.devlopes.shopping.repositories.ProdutoRepository;

@SpringBootApplication
public class ShoppingApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Jogos");
		Categoria cat2 = new Categoria(null, "Cursos");
		
		Produto p1 = new Produto(null, "Sea of Thives", 50.00);
		Produto p2 = new Produto(null, "Atlas", 55.00);
		Produto p3 = new Produto(null, "Java", 22.00);
		Produto p4 = new Produto(null, "Javascript", 25.00);
		Produto p5 = new Produto(null, "Jogos com Java", 45.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p5));
		cat2.getProdutos().addAll(Arrays.asList(p3, p4, p5));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}
