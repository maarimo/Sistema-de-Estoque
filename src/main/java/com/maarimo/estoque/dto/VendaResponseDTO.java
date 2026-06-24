package com.maarimo.estoque.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VendaResponseDTO(
        Long id,
        String cliente,
        BigDecimal valorTotal,
        LocalDateTime data
) {
}
