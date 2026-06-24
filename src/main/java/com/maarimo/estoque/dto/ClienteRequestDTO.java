package com.maarimo.estoque.dto;

public record ClienteRequestDTO(
        String nome,
        String telefone,
        String email
) {
}
