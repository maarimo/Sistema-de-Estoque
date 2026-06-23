package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.MovimentacaoRequestDTO;
import com.maarimo.estoque.dto.MovimentacaoResponseDTO;

import java.util.List;

public interface EstoqueService {

    void entrada(MovimentacaoRequestDTO dto);

    void saida(MovimentacaoRequestDTO dto);

    List<MovimentacaoResponseDTO> listarMovimentacoes();
}
