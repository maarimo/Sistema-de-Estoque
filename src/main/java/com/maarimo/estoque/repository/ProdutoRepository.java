package com.maarimo.estoque.repository;

import com.maarimo.estoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("""
       SELECT COUNT(p)
       FROM Produto p
       WHERE p.quantidade <= p.estoqueMinimo
       """)
    Long contarProdutosComEstoqueBaixo();
}