package com.maarimo.estoque.repository;

import com.maarimo.estoque.entity.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository
        extends JpaRepository<ItemVenda, Long> {
}
