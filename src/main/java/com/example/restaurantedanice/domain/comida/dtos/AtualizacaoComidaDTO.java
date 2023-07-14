package com.example.restaurantedanice.domain.comida.dtos;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoComidaDTO(

        @NotNull
        Long id,
        String titulo,
        String imagem,
        Double preco

) {
}
