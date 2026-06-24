package com.maarimo.estoque.exception;

import com.maarimo.estoque.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ProdutoNaoEncontradoException.class)
    public ResponseEntity<ApiErrorDTO>
    produtoNaoEncontrado(
            ProdutoNaoEncontradoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        new ApiErrorDTO(
                                LocalDateTime.now(),
                                404,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(
            ClienteNaoEncontradoException.class)
    public ResponseEntity<ApiErrorDTO>
    clienteNaoEncontrado(
            ClienteNaoEncontradoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        new ApiErrorDTO(
                                LocalDateTime.now(),
                                404,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(
            EstoqueInsuficienteException.class)
    public ResponseEntity<ApiErrorDTO>
    estoqueInsuficiente(
            EstoqueInsuficienteException ex) {

        return ResponseEntity.badRequest()
                .body(
                        new ApiErrorDTO(
                                LocalDateTime.now(),
                                400,
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(
            QuantidadeInvalidaException.class)
    public ResponseEntity<ApiErrorDTO>
    quantidadeInvalida(
            QuantidadeInvalidaException ex) {

        return ResponseEntity.badRequest()
                .body(
                        new ApiErrorDTO(
                                LocalDateTime.now(),
                                400,
                                ex.getMessage()
                        )
                );
    }
}