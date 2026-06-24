package com.maarimo.estoque.exception;

public class QuantidadeInvalidaException
        extends RuntimeException {

    public QuantidadeInvalidaException() {

        super("Quantidade deve ser maior que zero");
    }
}
