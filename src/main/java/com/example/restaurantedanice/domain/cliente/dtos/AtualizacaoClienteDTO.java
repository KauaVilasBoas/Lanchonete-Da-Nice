package com.example.restaurantedanice.domain.cliente.dtos;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoClienteDTO(

        @NotNull
        Long id,
        String nome,
        String telefone
) {
}
