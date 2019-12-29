package com.quebrastring.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.quebrastring.exceptions.CaracteresNaoPermitidos;
import com.quebrastring.exceptions.ComecaComNumerosException;
import com.quebrastring.resources.CamelCase;

public class CamelCaseTest {
	
	List<String> palavras;
	
	@Before
	public void iniciaValores() {
		palavras = new ArrayList<String>();
	}
	
	@Test
	public void umaPalavraLetrasMinuscula() throws Exception {
		palavras = CamelCase.converterCamelCase("nome");
		assertEquals("nome", palavras.get(0));
	}
	
	@Test
	public void umaPalavraPrimeiraLetraMaiuscula() throws Exception {
		palavras = CamelCase.converterCamelCase("Nome");
		assertEquals("nome", palavras.get(0));
	}
	
	@Test
	public void nomeComposto2Palavras() throws Exception {
		palavras = CamelCase.converterCamelCase("nomeComposto");
		assertEquals("nome", palavras.get(0));
		assertEquals("composto", palavras.get(1));
	}
	
	@Test
	public void nomeCompostoPrimeiraLetraMaiuscula2Palavras() throws Exception {
		palavras = CamelCase.converterCamelCase("NomeComposto");
		assertEquals("nome", palavras.get(0));
		assertEquals("composto", palavras.get(1));
	}
	
	@Test
	public void todasLetrasMaiusculas() throws Exception {
		palavras = CamelCase.converterCamelCase("CPF");
		assertEquals("CPF", palavras.get(0));
	}
	
	@Test
	public void palavraMinusculaSeguidaDeMaiuscula() throws Exception {
		palavras = CamelCase.converterCamelCase("numeroCPF");
		assertEquals("numero", palavras.get(0));
		assertEquals("CPF", palavras.get(1));
	}
	
	@Test
	public void palavraComNumeroNoMeio() throws Exception {
		palavras = CamelCase.converterCamelCase("recupera10Primeiros");
		assertEquals("recupera", palavras.get(0));
		assertEquals("10", palavras.get(1));
		assertEquals("primeiros", palavras.get(2));
	}
	
	@Test(expected=ComecaComNumerosException.class)
	public void naoComecarComNumero() throws Exception {
		palavras = CamelCase.converterCamelCase("10Primeiros");
	}
	
	@Test(expected=CaracteresNaoPermitidos.class)
	public void caracteresNaoPermitidos() throws Exception {
		palavras = CamelCase.converterCamelCase("nome#Composto");
	}
}
