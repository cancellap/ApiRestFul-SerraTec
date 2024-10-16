package org.serratec.bakcend.servicedto.controller;

import java.util.List;

import org.serratec.bakcend.servicedto.domain.Funcionario;
import org.serratec.bakcend.servicedto.dto.FuncionarioSalarioDTO;
import org.serratec.bakcend.servicedto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public ResponseEntity<List<Funcionario>> listar() {
		return ResponseEntity.ok(funcionarioRepository.findAll());
	}

	@GetMapping("/pagina")
	public ResponseEntity<Page<Funcionario>> listarPaginar(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable) {
		return ResponseEntity.ok(funcionarioRepository.findAll(pageable));
	}

	@GetMapping("/salario")
	public ResponseEntity<Page<Funcionario>> listarSalarios(
			@PageableDefault(page = 0, size = 10) @RequestParam Double valorMaximo, @RequestParam Double valorMinimo,
			Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioRepository.buscarSalario(valorMinimo, valorMaximo, pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/nome")
	public ResponseEntity<Page<Funcionario>> buscarPorNome(@RequestParam(defaultValue = "a") String paramNome,
			Pageable pageable) {
		return ResponseEntity.ok(funcionarioRepository.buscarPorNome(paramNome, pageable));
	}

	
	@GetMapping("/salarios-por-idade")
	public ResponseEntity<List<FuncionarioSalarioDTO>> buscarSalarioPorIdade(){
		return ResponseEntity.ok(funcionarioRepository.buscarSalrioPorIdade());
	}
}
