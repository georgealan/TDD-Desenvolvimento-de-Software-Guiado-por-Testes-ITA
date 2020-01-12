package com.caixaeletronico.interfaces;

import com.caixaeletronico.resources.ContaCorrente;

public interface ServicoRemoto {
    public ContaCorrente recuperarConta(String numero);
    public void persistirConta(ContaCorrente conta);
}
