package com.maarimo.estoque.dto;

import java.time.LocalDateTime;

public record ApiErrorDTO(

        LocalDateTime timestamp,

        int status,

        String erro

) {
}
