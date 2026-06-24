package com.maarimo.estoque.controller;

import com.maarimo.estoque.dto.ClienteRequestDTO;
import com.maarimo.estoque.dto.ClienteResponseDTO;
import com.maarimo.estoque.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(
            @RequestBody ClienteRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {

        return ResponseEntity.ok(service.listar());
    }
}
