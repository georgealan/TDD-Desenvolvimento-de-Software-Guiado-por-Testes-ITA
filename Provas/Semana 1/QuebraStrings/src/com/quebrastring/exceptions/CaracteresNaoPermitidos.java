package com.quebrastring.exceptions;

public class CaracteresNaoPermitidos extends Exception{
	private static final long serialVersionUID = 1L;

	public CaracteresNaoPermitidos() {
		super("Inv�lido - caracteres especiais n�o s�o permitidos, somente letras e n�meros");		
	}
	
}
