package br.com.mercadolivre.apimutants.exception;

public class IsNotMutantException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IsNotMutantException(String message) {
		super(message);
	}
}
