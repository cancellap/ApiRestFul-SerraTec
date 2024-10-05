package com.exercicio.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.domain.Aluno;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	private static List<Aluno> listaDeAluno = new ArrayList<Aluno>();

	static {
		listaDeAluno.add(new Aluno(2354L, "Pedro", "243594859"));
		listaDeAluno.add(new Aluno(2343L, "Anna", "2534534859"));
		listaDeAluno.add(new Aluno(1409L, "Laila", "3453464352"));
	};

	@GetMapping
	public List<Aluno> listar() {
		return listaDeAluno;
	}

	@GetMapping("/{matricula}")
	public Aluno buscarMatricula(@PathVariable Long matricula) {
		return listaDeAluno.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);
	}

	@PostMapping
	public Aluno inserirAluno(@RequestBody Aluno aluno) {
		listaDeAluno.add(aluno);
		return aluno;
	}

	@PutMapping("/{matricula}")
	public Aluno atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		for (int i=0; i<listaDeAluno.size(); i++) {
			if (listaDeAluno.get(i).getMatricula().equals(matricula)) {
				Aluno a = new Aluno(matricula, aluno.getNome(), aluno.getTelefone());
				listaDeAluno.set(i, a);
				return a;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{matricula}")
	public void delete(@PathVariable Long matricula) {
		 listaDeAluno.removeIf(aluno -> aluno.getMatricula().equals(matricula));	
	}
}
