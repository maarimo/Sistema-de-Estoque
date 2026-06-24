package com.maarimo.estoque.controller;

import com.maarimo.estoque.dto.DashboardResponseDTO;
import com.maarimo.estoque.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<DashboardResponseDTO> dashboard() {

        return ResponseEntity.ok(
                service.obterDashboard()
        );
    }
}
