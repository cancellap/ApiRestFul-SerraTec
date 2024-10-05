package com.exercicio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.domain.Veiculo;


@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	private static List<Veiculo> lista = new ArrayList<Veiculo>();
	static {
		lista.add(new Veiculo(123,"Fiat", "palio"));
		lista.add(new Veiculo(343,"Fiat", "uno"));
		lista.add(new Veiculo(564,"ford", "ka"));
	}
	
	@GetMapping
	public List<Veiculo> getveiculo(){
		return lista;
	}
	
	@GetMapping("/{id}")
	public Veiculo buscarVeiculo(@PathVariable Integer id) {
		return lista.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
	}
	
	@PutMapping
	public Veiculo atualizar(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
		return lista.stream().filter(v-> v.getId().equals(id)).findFirst().map(v-> {
			v.setMarca(veiculo.getMarca());
			v.setModelo(veiculo.getModelo());
			return v;
		}).orElse(null);
	}
	
	@PostMapping
	public Veiculo postVeiculo(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}
	@DeleteMapping("/{id}")
	public void deleteVeiculo(@PathVariable Integer id) {
		lista.removeIf(v -> v.getId().equals(id));
	}
	
}
