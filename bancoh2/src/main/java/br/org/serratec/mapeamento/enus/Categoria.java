package br.org.serratec.mapeamento.enus;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.mapeamento.exception.EnumValidationException;

public enum Categoria {
	SEDAN, HATCH, SUV, PICKUP, UTILITARIO;

	@JsonCreator
	public static Categoria verifica(String values) throws EnumValidationException {
		for (Categoria c : values()) {
			if (values.equals(c.name())) {
				return c;
			}
		}
		throw new EnumValidationException("Categoria preenchida incorrtamente");
	}
}
