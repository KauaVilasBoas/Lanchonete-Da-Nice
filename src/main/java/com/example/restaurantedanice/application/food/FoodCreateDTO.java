package com.example.restaurantedanice.application.food;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodCreateDTO(
        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        @NotBlank(message = "Imagem é obrigatório")
        String imagem,
        @NotNull(message = "Preço é obrigatório")
        Double preco

) {
}
