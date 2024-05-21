package com.example.restaurantedanice.application.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientCreateDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório, ou o email já é existente")
                @Email(message = "O formato do email é inválido")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        String cpf) {
}
