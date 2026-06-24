package com.maarimo.estoque.controller;

import com.maarimo.estoque.dto.VendaRequestDTO;
import com.maarimo.estoque.dto.VendaResponseDTO;
import com.maarimo.estoque.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VendaResponseDTO>
    registrar(@RequestBody VendaRequestDTO dto){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.registrarVenda(dto));
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>>
    listar(){

        return ResponseEntity.ok(service.listar());
    }
}
