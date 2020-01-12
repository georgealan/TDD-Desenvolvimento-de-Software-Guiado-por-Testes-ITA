package com.caixaeletronico;

import com.caixaeletronico.exceptions.HardwareException;
import com.caixaeletronico.interfaces.Hardware;

public class MockHardwareDefeituoso implements Hardware {
    @Override
    public String pegarNumeroDaContaCartão() {
        throw new HardwareException("Falha de funcionamento do hardware");
    }

    @Override
    public void entregarDinheiro() {
        throw new HardwareException("Falha de funcionamento do hardware");
    }

    @Override
    public void lerEnvelope() {
        throw new HardwareException("Falha de funcionamento do hardware");
    }
}
