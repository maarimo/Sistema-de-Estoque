package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.ItemVendaRequestDTO;
import com.maarimo.estoque.dto.VendaRequestDTO;
import com.maarimo.estoque.dto.VendaResponseDTO;
import com.maarimo.estoque.entity.*;
import com.maarimo.estoque.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class VendaServiceImpl implements VendaService {

    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final MovimentacaoEstoqueRepository movimentacaoRepository;

    public VendaServiceImpl(VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository, MovimentacaoEstoqueRepository movimentacaoRepository) {
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.movimentacaoRepository = movimentacaoRepository;
    }

    @Override
    public VendaResponseDTO registrarVenda(
            VendaRequestDTO dto) {

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        Venda venda = Venda.builder()
                .cliente(cliente)
                .data(LocalDateTime.now())
                .valorTotal(BigDecimal.ZERO)
                .build();

        vendaRepository.save(venda);

        BigDecimal total = BigDecimal.ZERO;

        for (ItemVendaRequestDTO itemDTO : dto.itens()) {

            Produto produto = produtoRepository.findById(
                            itemDTO.produtoId())
                    .orElseThrow(() ->
                            new RuntimeException("Produto não encontrado"));

            if (produto.getQuantidade() < itemDTO.quantidade()) {
                throw new RuntimeException(
                        "Estoque insuficiente para "
                                + produto.getNome());
            }

            produto.setQuantidade(
                    produto.getQuantidade() - itemDTO.quantidade());

            produtoRepository.save(produto);

            BigDecimal subtotal =
                    produto.getPrecoVenda()
                            .multiply(
                                    BigDecimal.valueOf(
                                            itemDTO.quantidade()));

            total = total.add(subtotal);

            ItemVenda item = ItemVenda.builder()
                    .venda(venda)
                    .produto(produto)
                    .quantidade(itemDTO.quantidade())
                    .precoUnitario(produto.getPrecoVenda())
                    .subtotal(subtotal)
                    .build();

            itemVendaRepository.save(item);

            MovimentacaoEstoque movimentacao =
                    MovimentacaoEstoque.builder()
                            .produto(produto)
                            .quantidade(itemDTO.quantidade())
                            .tipo(TipoMovimentacao.SAIDA)
                            .data(LocalDateTime.now())
                            .build();

            movimentacaoRepository.save(movimentacao);
        }

        venda.setValorTotal(total);

        vendaRepository.save(venda);

        return new VendaResponseDTO(
                venda.getId(),
                cliente.getNome(),
                venda.getValorTotal(),
                venda.getData()
        );
    }

    @Override
    public List<VendaResponseDTO> listar() {

        return vendaRepository.findAll()
                .stream()
                .map(v -> new VendaResponseDTO(
                        v.getId(),
                        v.getCliente().getNome(),
                        v.getValorTotal(),
                        v.getData()))
                .toList();
    }
}