package dev.devlopes.shopping;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.devlopes.shopping.domain.Categoria;
import dev.devlopes.shopping.repositories.CategoriaRepository;

@SpringBootApplication
public class ShoppingApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Jogos");
		Categoria cat2 = new Categoria(null, "Cursos");
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
	}

}
