package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.ProdutoRequestDTO;
import com.maarimo.estoque.dto.ProdutoResponseDTO;
import com.maarimo.estoque.entity.Categoria;
import com.maarimo.estoque.entity.Produto;
import com.maarimo.estoque.exception.ProdutoNaoEncontradoException;
import com.maarimo.estoque.repository.CategoriaRepository;
import com.maarimo.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoServiceImpl(ProdutoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        Produto produto = Produto.builder()
                .codigo(dto.codigo())
                .nome(dto.nome())
                .descricao(dto.descricao())
                .precoCusto(dto.precoCusto())
                .precoVenda(dto.precoVenda())
                .quantidade(dto.quantidade())
                .estoqueMinimo(dto.estoqueMinimo())
                .categoria(categoria)
                .build();

        repository.save(produto);

        return converter(produto);
    }

    private ProdutoResponseDTO converter(Produto produto) {

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getCodigo(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda(),
                produto.getQuantidade(),
                produto.getEstoqueMinimo(),
                produto.getCategoria() != null
                        ? produto.getCategoria().getNome()
                        : null
        );
    }

    @Override
    public List<ProdutoResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::converter)
                .toList();
    }

    @Override
    public ProdutoResponseDTO buscarPorId(Long id) {

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        return converter(produto);
    }

    @Override
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {

        Produto produto = repository.findById(id)
                .orElseThrow(() ->
                        new ProdutoNaoEncontradoException(id));

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        produto.setCodigo(dto.codigo());
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPrecoCusto(dto.precoCusto());
        produto.setPrecoVenda(dto.precoVenda());
        produto.setQuantidade(dto.quantidade());
        produto.setEstoqueMinimo(dto.estoqueMinimo());
        produto.setCategoria(categoria);

        repository.save(produto);

        return converter(produto);
    }

    @Override
    public void deletar(Long id) {

        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        repository.delete(produto);
    }

}