package br.org.serratec.mapeamento.injecao;

import org.springframework.stereotype.Component;

@Component
public class Pagamento {

	private Consulta consulta;
	private Exame exame = new Exame();

	public Pagamento(Consulta consulta, Exame exame) {
		super();
		this.consulta = consulta;
		this.exame = exame;
	}


	public Double calculaProcedimento(Double valorConsulta, Double valorExame) {
		return consulta.calcularConsula(valorConsulta)
				+ exame.calularExame(valorExame);
	}
}
