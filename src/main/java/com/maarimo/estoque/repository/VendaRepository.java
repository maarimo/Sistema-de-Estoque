package com.maarimo.estoque.repository;

import com.maarimo.estoque.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository
        extends JpaRepository<Venda, Long> {
}
