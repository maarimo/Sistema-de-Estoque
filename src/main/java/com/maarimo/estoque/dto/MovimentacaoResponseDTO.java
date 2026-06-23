package com.maarimo.estoque.dto;

import com.maarimo.estoque.entity.TipoMovimentacao;

import java.time.LocalDateTime;

public record MovimentacaoResponseDTO(
        Long id,
        String produto,
        Integer quantidade,
        TipoMovimentacao tipo,
        LocalDateTime data
) {
}
