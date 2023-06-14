package com.example.restaurantedanice.domain.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório, ou o email já é existente")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        String cpf) {
}
