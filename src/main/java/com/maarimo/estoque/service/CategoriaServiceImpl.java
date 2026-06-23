package com.maarimo.estoque.service;

import com.maarimo.estoque.dto.CategoriaRequestDTO;
import com.maarimo.estoque.dto.CategoriaResponseDTO;
import com.maarimo.estoque.entity.Categoria;
import com.maarimo.estoque.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoriaResponseDTO criar(CategoriaRequestDTO dto) {

        Categoria categoria = Categoria.builder()
                .nome(dto.nome())
                .build();

        repository.save(categoria);

        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome()
        );
    }

    @Override
    public List<CategoriaResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(c -> new CategoriaResponseDTO(
                        c.getId(),
                        c.getNome()))
                .toList();
    }
}
