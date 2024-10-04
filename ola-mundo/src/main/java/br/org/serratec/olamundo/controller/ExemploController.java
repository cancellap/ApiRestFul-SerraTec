package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {

	@GetMapping
	public String teste() {
		return "Exemplo de Controller";
	}
	@GetMapping("/oi")
	public String oi() {
		return "Oi";
	}
	//                    passando paramentro para o request
	//http://localhost:8080/api/v1/maiuscula?valor=pedro
	@GetMapping("/maiuscula")
	public String maiuscula(@RequestParam String nome, @RequestParam String sobreNome) {
		return nome.toUpperCase().concat(" " +sobreNome.toUpperCase());
	}
	
}
