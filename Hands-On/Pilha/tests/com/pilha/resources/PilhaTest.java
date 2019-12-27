package com.pilha.resources;

import com.pilha.exception.PilhaCheiaException;
import com.pilha.exception.PilhaVaziaException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A classe de teste é criada antes da classe do código, por conveniencia a IDE Intellij pode criar antes uma
 * classe vazia para depois criar uma de teste, na verdade da no mesmo porque será necessário criar a classe
 * do código.
 * Criamos todos os métodos que achamos que vamos utilizar e pensamos no comportamento que eles terão.
 */
public class PilhaTest {

    private Pilha p;

    @Before
    public void inicializaPilha(){
        p = new Pilha(10);
    }

    @Test
    public void pilhaVazia(){
        assertTrue(p.estaVazia());
        assertEquals(0, p.tamanho());
    }

    @Test
    public void empilhaUmElemento(){
        p.empilha("Primeiro");
        assertFalse(p.estaVazia());
        assertEquals(1, p.tamanho());
        assertEquals("Primeiro", p.topo());
    }

    @Test
    public void empilhaDesempilha(){
        p.empilha("Primeiro");
        p.empilha("Segundo");
        assertEquals(2, p.tamanho());
        assertEquals("Segundo", p.topo());
        Object desempilhado = p.desempilha();
        assertEquals(1, p.tamanho());
        assertEquals("Primeiro", p.topo());
        assertEquals("Segundo", desempilhado);
    }

    // Teste que espera uma exeption de erro.
    @Test(expected = PilhaVaziaException.class)
    public void removeDaPilhaVazia(){
        p.desempilha();
    }

    @Test
    public void adicionaNaPilhaCheia(){
        for (int i = 0; i < 10; i++){
            p.empilha("elemento" + i);
        }
        try {
            p.empilha("boom");
            fail();
        }catch (PilhaCheiaException e){

        }

    }
}