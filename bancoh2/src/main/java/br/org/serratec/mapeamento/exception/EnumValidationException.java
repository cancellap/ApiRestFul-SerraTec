package br.org.serratec.mapeamento.exception;

public class EnumValidationException extends Exception  {

	private static final long serialVersionUID = 1L;
	
	public EnumValidationException(String message) {
		super(message);
	}
}