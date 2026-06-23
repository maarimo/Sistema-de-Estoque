package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.MovimentacaoRequestDTO;
import com.maarimo.estoque.dto.MovimentacaoResponseDTO;
import com.maarimo.estoque.entity.MovimentacaoEstoque;
import com.maarimo.estoque.entity.Produto;
import com.maarimo.estoque.entity.TipoMovimentacao;
import com.maarimo.estoque.repository.MovimentacaoEstoqueRepository;
import com.maarimo.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class EstoqueServiceImpl implements EstoqueService {

    private final ProdutoRepository produtoRepository;
    private final MovimentacaoEstoqueRepository movimentacaoRepository;

    public EstoqueServiceImpl(ProdutoRepository produtoRepository, MovimentacaoEstoqueRepository movimentacaoRepository) {
        this.produtoRepository = produtoRepository;
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public void entrada(MovimentacaoRequestDTO dto) {

        Produto produto = buscarProduto(dto.produtoId());

        produto.setQuantidade(
                produto.getQuantidade() + dto.quantidade()
        );

        produtoRepository.save(produto);

        registrarMovimentacao(
                produto,
                dto.quantidade(),
                TipoMovimentacao.ENTRADA
        );
    }

    @Override
    public void saida(MovimentacaoRequestDTO dto) {

        Produto produto = buscarProduto(dto.produtoId());

        if (produto.getQuantidade() < dto.quantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        produto.setQuantidade(
                produto.getQuantidade() - dto.quantidade()
        );

        produtoRepository.save(produto);

        registrarMovimentacao(
                produto,
                dto.quantidade(),
                TipoMovimentacao.SAIDA
        );
    }

    @Override
    public List<MovimentacaoResponseDTO> listarMovimentacoes() {

        return movimentacaoRepository.findAll()
                .stream()
                .map(this::converter)
                .toList();
    }

    private Produto buscarProduto(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
    }

    private void registrarMovimentacao(
            Produto produto,
            Integer quantidade,
            TipoMovimentacao tipo) {

        MovimentacaoEstoque movimentacao =
                MovimentacaoEstoque.builder()
                        .produto(produto)
                        .quantidade(quantidade)
                        .tipo(tipo)
                        .data(LocalDateTime.now())
                        .build();

        movimentacaoRepository.save(movimentacao);
    }

    private MovimentacaoResponseDTO converter(
            MovimentacaoEstoque movimentacao) {

        return new MovimentacaoResponseDTO(
                movimentacao.getId(),
                movimentacao.getProduto().getNome(),
                movimentacao.getQuantidade(),
                movimentacao.getTipo(),
                movimentacao.getData()
        );
    }
}
