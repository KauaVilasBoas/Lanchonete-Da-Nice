package com.example.restaurantedanice.application.client;

import jakarta.validation.constraints.NotNull;

public record ClientUpdateDTO(

        @NotNull
        Long id,
        String nome,
        String telefone
) {
}
