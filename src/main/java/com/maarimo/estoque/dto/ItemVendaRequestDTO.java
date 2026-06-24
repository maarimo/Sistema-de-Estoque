package com.maarimo.estoque.dto;

public record ItemVendaRequestDTO(
        Long produtoId,
        Integer quantidade
) {
}
