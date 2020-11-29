package dev.devlopes.shopping.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.devlopes.shopping.domain.Produto;
import dev.devlopes.shopping.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos() {
		List<Produto> lista = service.buscarTodos();
		return ResponseEntity.ok(lista);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Produto produto = service.buscar(id);
		return ResponseEntity.ok(produto);
	}

}
