package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.ClienteRequestDTO;
import com.maarimo.estoque.dto.ClienteResponseDTO;
import com.maarimo.estoque.entity.Cliente;
import com.maarimo.estoque.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClienteResponseDTO criar(ClienteRequestDTO dto) {

        Cliente cliente = Cliente.builder()
                .nome(dto.nome())
                .telefone(dto.telefone())
                .email(dto.email())
                .build();

        repository.save(cliente);

        return converter(cliente);
    }

    @Override
    public List<ClienteResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(this::converter)
                .toList();
    }

    private ClienteResponseDTO converter(Cliente cliente) {

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }
}
