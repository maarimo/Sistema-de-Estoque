package com.maarimo.estoque.dto;

import java.util.List;

public record VendaRequestDTO(
        Long clienteId,
        List<ItemVendaRequestDTO> itens
) {
}
