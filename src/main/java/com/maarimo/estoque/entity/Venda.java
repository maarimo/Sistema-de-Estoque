package com.maarimo.estoque.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private LocalDateTime data;

    private BigDecimal valorTotal;
}