package com.mocktests.resouces;

import com.mocktests.interfaces.ObservadorCarrinho;

public class MockObservadorComProblema  implements ObservadorCarrinho {
    @Override
    public void produtoAdicionado(String nome, int valor) {
        throw new RuntimeException("Problema simulado pelo mock");
    }
}
