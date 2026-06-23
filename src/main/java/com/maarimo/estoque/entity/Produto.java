package com.maarimo.estoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String nome;

    private String descricao;

    private BigDecimal precoCusto;

    private BigDecimal precoVenda;

    private Integer quantidade;

    private Integer estoqueMinimo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}