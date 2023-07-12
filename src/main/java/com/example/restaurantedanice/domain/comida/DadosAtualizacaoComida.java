package com.example.restaurantedanice.domain.comida;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoComida(

        @NotNull
        Long id,
        String titulo,
        String imagem,
        Double preco

) {
}
