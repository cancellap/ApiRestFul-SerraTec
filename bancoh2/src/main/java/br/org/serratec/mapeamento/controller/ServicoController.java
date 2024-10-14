package br.org.serratec.mapeamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.mapeamento.domain.Servico;
import br.org.serratec.mapeamento.repository.SerivicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

	@Autowired
	private SerivicoRepository servicoRepository;

	@Operation(summary = "Lista todos os servicos", description = "A resposta lista os dados dos "
			+ "servicos id, descricao, valor")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = Servico.class), mediaType = "application/json") }, description = "Retorna todos os clientes"),
			@ApiResponse(responseCode = "401", description = "Erro na autenticação"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") })
	@GetMapping
	public ResponseEntity<List<Servico>> listar() {
		return ResponseEntity.ok(servicoRepository.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> buscar(@PathVariable Long id) {
		Optional<Servico> manutencaoOpt = servicoRepository.findById(id);
		if (manutencaoOpt.isPresent()) {
			return ResponseEntity.ok(manutencaoOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico inserir(@RequestBody Servico servico) {
		return servicoRepository.save(servico);
	}

}
