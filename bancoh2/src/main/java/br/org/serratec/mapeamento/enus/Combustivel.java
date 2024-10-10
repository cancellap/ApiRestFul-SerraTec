package br.org.serratec.mapeamento.enus;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.mapeamento.exception.EnumValidationException;

public enum Combustivel {

	ALCOOL(1, "Álcool"), GASOLINA(2, "Gasolina"), DIESEL(3, "Diesel"), FLEX(4, "Flex");

	private Integer codigo;
	private String tipo;

	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	//Verifaca se o enum passado dentro do json esta dentro dos enum's feitos
	//caso nao, landça uma excecao do tipo EnumValidationException que herda de HttpMessageNotReadableException 
	@JsonCreator
	public static Combustivel verifica(Integer valor)	throws EnumValidationException{
		for (Combustivel c : values()) {
			if(valor.equals(c.getCodigo())) {
				return c;
			}
		}
		throw new EnumValidationException("Combustivel invalido");
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

}
