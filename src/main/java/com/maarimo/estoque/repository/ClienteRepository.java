package com.maarimo.estoque.repository;

import com.maarimo.estoque.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {
}
