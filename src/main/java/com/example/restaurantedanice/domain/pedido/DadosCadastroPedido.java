package com.example.restaurantedanice.domain.pedido;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCadastroPedido(@NotNull Long idCliente, @NotNull List<Long> idComidaList) {
}
