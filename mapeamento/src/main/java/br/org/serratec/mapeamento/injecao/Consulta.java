package br.org.serratec.mapeamento.injecao;

import org.springframework.stereotype.Component;

@Component
public class Consulta {

	public Double calcularConsula(Double valor) {
		return valor = valor + valor * 0.1;
	}
}
