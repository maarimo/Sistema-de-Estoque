package com.maarimo.estoque.dto;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String telefone,
        String email
) {
}
