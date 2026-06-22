package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.ProdutoRequestDTO;
import com.maarimo.estoque.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {

    ProdutoResponseDTO criar(ProdutoRequestDTO dto);

    List<ProdutoResponseDTO> listar();

    ProdutoResponseDTO buscarPorId(Long id);

    ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto);

    void deletar(Long id);
}
