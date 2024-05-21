package com.example.restaurantedanice.application.food;

import jakarta.validation.constraints.NotNull;

public record FoodUpdateDTO(

        @NotNull
        Long id,
        String titulo,
        String imagem,
        Double preco

) {
}
