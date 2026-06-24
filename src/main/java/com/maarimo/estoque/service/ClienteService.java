package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.ClienteRequestDTO;
import com.maarimo.estoque.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {

    ClienteResponseDTO criar(ClienteRequestDTO dto);

    List<ClienteResponseDTO> listar();
}
