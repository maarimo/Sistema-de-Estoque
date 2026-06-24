package com.maarimo.estoque.exception;

public class ClienteNaoEncontradoException
        extends RuntimeException {

    public ClienteNaoEncontradoException(Long id) {

        super("Cliente não encontrado. ID: " + id);
    }
}
