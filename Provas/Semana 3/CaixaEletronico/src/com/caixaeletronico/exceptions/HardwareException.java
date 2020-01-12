package com.caixaeletronico.exceptions;

public class HardwareException extends RuntimeException{
    public HardwareException(String mensagem){
        super(mensagem);
    }
}
