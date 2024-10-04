package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ExercicioDeController {

	@GetMapping("/soma")
	public double soma(@RequestParam Double valor1, @RequestParam Double valor2) {
		return valor1 + valor2;
	}

	@GetMapping("/subtracao")
	public double subtracao(@RequestParam Double valor1, @RequestParam Double valor2) {
		return valor1 - valor2;
	}
	@GetMapping("/multiplicacao")
	public double multiplicacao(@RequestParam Double valor1, @RequestParam Double valor2) {
		return valor1 * valor2;
	}


}

