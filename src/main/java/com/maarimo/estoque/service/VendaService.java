package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.VendaRequestDTO;
import com.maarimo.estoque.dto.VendaResponseDTO;

import java.util.List;

public interface VendaService {

    VendaResponseDTO registrarVenda(
            VendaRequestDTO dto);

    List<VendaResponseDTO> listar();
}
