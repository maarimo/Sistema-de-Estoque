package com.maarimo.estoque.service;

import com.maarimo.estoque.entity.Categoria;
import com.maarimo.estoque.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public DataLoader(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {

        if (categoriaRepository.count() == 0) {

            categoriaRepository.save(
                    Categoria.builder()
                            .nome("Eletrônicos")
                            .build()
            );

            categoriaRepository.save(
                    Categoria.builder()
                            .nome("Informática")
                            .build()
            );
        }
    }
}
