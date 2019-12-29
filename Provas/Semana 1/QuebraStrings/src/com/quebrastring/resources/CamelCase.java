package com.quebrastring.resources;

import java.util.ArrayList;
import java.util.List;

import com.quebrastring.exceptions.CaracteresNaoPermitidos;
import com.quebrastring.exceptions.ComecaComNumerosException;

public class CamelCase {

	private static ArrayList<String> palavras;
	
	public static List<String> converterCamelCase(String original)
			throws ComecaComNumerosException, CaracteresNaoPermitidos {
		verificaExecoes(original);
		palavras = new ArrayList<>();
		if (original.toUpperCase().equals(original)) {
			String maiuscula = original;
			palavras.add(maiuscula);
		} else {
			quebraString(original);
		}
		return palavras;
	}
	
	private static void verificaExecoes(String palavra) 
			throws ComecaComNumerosException, CaracteresNaoPermitidos {
		String primeiraLetra = Character.toString(palavra.charAt(0));
		if (primeiraLetra.matches("[0-9]"))
			throw new ComecaComNumerosException();
		if (palavra.matches(".*\\W.*")) {
			throw new CaracteresNaoPermitidos();
		}
	}

	public static String maiusculaParaMinuscula(String palavra) {
		if (palavra.toUpperCase().equals(palavra)) {
			palavra = palavra.toUpperCase();
		} else {
			palavra = palavra.toLowerCase();
		}
		return palavra;
	}

	public static List<String> quebraString(String palavra) {
		String[] palavrasDivididas = palavra.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])|(?<=\\D)(?=\\d)");
		palavras = new ArrayList<>();
		for (String p : palavrasDivididas) {
			p = maiusculaParaMinuscula(p);
			palavras.add(p);
		}
		return palavras;
	}
}
