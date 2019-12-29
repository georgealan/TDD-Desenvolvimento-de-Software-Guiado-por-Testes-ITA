package com.quebrastring.exceptions;

public class ComecaComNumerosException extends Exception{
	private static final long serialVersionUID = 1L;

	public ComecaComNumerosException() {
		super("Inválido - não deve começar com números");
	}
	
	
}
