package br.org.serratec.mapeamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.mapeamento.domain.Proprietario;
import br.org.serratec.mapeamento.repository.ProprietarioRepository;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

	@Autowired
	private ProprietarioRepository pr;

	@GetMapping
	public ResponseEntity<List<Proprietario>> lista() {
		return ResponseEntity.ok(pr.findAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario inserir (@RequestBody Proprietario prop){
		return pr.save(prop);
	}
	//para receber uma lista dentro do body
	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Proprietario> inserirVarios(@RequestBody List<Proprietario> proprietarios) {
		return pr.saveAll(proprietarios);
	}
}
