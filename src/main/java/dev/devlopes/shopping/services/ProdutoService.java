package dev.devlopes.shopping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.devlopes.shopping.domain.Produto;
import dev.devlopes.shopping.repositories.ProdutoRepository;
import dev.devlopes.shopping.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Não foi encontrado nenhum produto com esse id!")
		);
	}
	
	public List<Produto> buscarTodos() {
		return repo.findAll();
	}
	
}
