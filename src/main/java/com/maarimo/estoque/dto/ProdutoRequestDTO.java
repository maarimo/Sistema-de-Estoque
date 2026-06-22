package com.maarimo.estoque.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoRequestDTO(

        @Schema(example = "P001")
        @NotBlank
        String codigo,

        @Schema(example = "Notebook Dell")
        @NotBlank
        String nome,

        @Schema(example = "Notebook i5 16GB RAM")
        String descricao,

        @Schema(example = "2500.00")
        @NotNull
        BigDecimal precoCusto,

        @Schema(example = "3200.00")
        @NotNull
        BigDecimal precoVenda,

        @Schema(example = "15")
        @NotNull
        Integer quantidade,

        @Schema(example = "3")
        @NotNull
        Integer estoqueMinimo

) {}
