package dev.devlopes.shopping;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.devlopes.shopping.domain.Categoria;
import dev.devlopes.shopping.domain.Cidade;
import dev.devlopes.shopping.domain.Estado;
import dev.devlopes.shopping.domain.Produto;
import dev.devlopes.shopping.repositories.CategoriaRepository;
import dev.devlopes.shopping.repositories.CidadeRepository;
import dev.devlopes.shopping.repositories.EstadoRepository;
import dev.devlopes.shopping.repositories.ProdutoRepository;

@SpringBootApplication
public class ShoppingApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepo;

	@Autowired
	private ProdutoRepository prodRepo;

	@Autowired
	private CidadeRepository cidRepo;

	@Autowired
	private EstadoRepository estRepo;
	
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
		
		Estado est1 = new Estado(null, "Brasília");
		Estado est2 = new Estado(null, "Goiás");
		
		Cidade c1 = new Cidade(null, "Arniqueiras", est1);
		Cidade c2 = new Cidade(null, "Ceilândia", est1);
		Cidade c3 = new Cidade(null, "Águas Lindas", est2);
		Cidade c4 = new Cidade(null, "Edilândia", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3, c4));
		
		estRepo.saveAll(Arrays.asList(est1, est2));
		cidRepo.saveAll(Arrays.asList(c1, c2, c3, c4));
	}

}
