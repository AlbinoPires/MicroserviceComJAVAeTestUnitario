package com.estudos.testmspessoa.exceptions;


public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String cpf) {
        super("CPF inválido (mínimo 9 dígitos): " + cpf);
    }
}