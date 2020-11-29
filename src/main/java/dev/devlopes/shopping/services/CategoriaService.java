package dev.devlopes.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.devlopes.shopping.domain.Categoria;
import dev.devlopes.shopping.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Categoria> buscarTodas() {
		
		List<Categoria> list = repo.findAll();
		
		return list;
	}
	
}
