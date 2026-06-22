package com.maarimo.estoque.dto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String codigo,
        String nome,
        String descricao,
        BigDecimal precoCusto,
        BigDecimal precoVenda,
        Integer quantidade,
        Integer estoqueMinimo
) {}