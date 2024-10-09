package br.org.serratec.mapeamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.mapeamento.domain.Produto;
import br.org.serratec.mapeamento.repository.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listar() {
		// retorna uma lista de produto
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> pesquisar(@PathVariable Long id) {
		Optional<Produto> produtoOpt = produtoRepository.findById(id);
		if (produtoOpt.isPresent()) {
			return ResponseEntity.ok(produtoOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@Valid @RequestBody Produto produto) {
		produto = produtoRepository.save(produto);
		return produto;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
