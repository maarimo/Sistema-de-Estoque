package com.maarimo.estoque.dto;

import java.math.BigDecimal;

public record DashboardResponseDTO(

        Long totalProdutos,
        Long produtosEstoqueBaixo,
        Long totalClientes,
        Long totalVendas,
        BigDecimal faturamentoTotal

) {
}
