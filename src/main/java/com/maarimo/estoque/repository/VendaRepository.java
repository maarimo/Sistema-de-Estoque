package com.maarimo.estoque.repository;

import com.maarimo.estoque.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface VendaRepository
        extends JpaRepository<Venda, Long> {
    @Query("""
       SELECT COALESCE(SUM(v.valorTotal),0)
       FROM Venda v
       """)
    BigDecimal calcularFaturamentoTotal();
}
