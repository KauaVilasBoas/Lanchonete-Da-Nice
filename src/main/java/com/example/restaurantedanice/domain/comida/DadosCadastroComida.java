package com.example.restaurantedanice.domain.comida;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroComida(
        @NotBlank(message = "Titulo é obrigatório")
        String titulo,
        @NotBlank(message = "Imagem é obrigatório")
        String imagem,
        @NotNull(message = "Preço é obrigatório")
        Double preco

) {
}
