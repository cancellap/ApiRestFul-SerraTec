package br.org.serratec.mapeamento.injecao;

import org.springframework.stereotype.Component;

@Component
public class Exame {

	public Double calularExame(Double valor) {
		return valor = valor * 0.05;
	}
}
