package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.CategoriaRequestDTO;
import com.maarimo.estoque.dto.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDTO criar(CategoriaRequestDTO dto);

    List<CategoriaResponseDTO> listar();
}
