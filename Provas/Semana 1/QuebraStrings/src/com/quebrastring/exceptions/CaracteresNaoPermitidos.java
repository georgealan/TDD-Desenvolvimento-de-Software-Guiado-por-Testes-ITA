package com.quebrastring.exceptions;

public class CaracteresNaoPermitidos extends Exception{
	private static final long serialVersionUID = 1L;

	public CaracteresNaoPermitidos() {
		super("Inválido - caracteres especiais não são permitidos, somente letras e números");		
	}
	
}
