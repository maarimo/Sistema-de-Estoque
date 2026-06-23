package com.maarimo.estoque.dto;

public record MovimentacaoRequestDTO(
        Long produtoId,
        Integer quantidade
) {
}
