package com.maarimo.estoque.controller;

import com.maarimo.estoque.dto.MovimentacaoRequestDTO;
import com.maarimo.estoque.dto.MovimentacaoResponseDTO;
import com.maarimo.estoque.service.EstoqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @PostMapping("/entrada")
    public ResponseEntity<Void> entrada(
            @RequestBody MovimentacaoRequestDTO dto){

        service.entrada(dto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/saida")
    public ResponseEntity<Void> saida(
            @RequestBody MovimentacaoRequestDTO dto){

        service.saida(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/movimentacoes")
    public ResponseEntity<List<MovimentacaoResponseDTO>>
    listar(){

        return ResponseEntity.ok(
                service.listarMovimentacoes()
        );
    }
}
