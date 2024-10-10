package br.org.serratec.mapeamento.domain;

import br.org.serratec.mapeamento.enus.Categoria;
import br.org.serratec.mapeamento.enus.Combustivel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Cacteristicas {

	private String renavan;

	private String chassi;

	private Integer ano;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;

	private String cor;

	public String getRenavan() {
		return renavan;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}



}
