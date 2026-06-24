package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.DashboardResponseDTO;
import com.maarimo.estoque.repository.ClienteRepository;
import com.maarimo.estoque.repository.ProdutoRepository;
import com.maarimo.estoque.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final VendaRepository vendaRepository;

    @Override
    public DashboardResponseDTO obterDashboard() {

        return new DashboardResponseDTO(

                produtoRepository.count(),

                produtoRepository.contarProdutosComEstoqueBaixo(),

                clienteRepository.count(),

                vendaRepository.count(),

                vendaRepository.calcularFaturamentoTotal()
        );
    }
}
