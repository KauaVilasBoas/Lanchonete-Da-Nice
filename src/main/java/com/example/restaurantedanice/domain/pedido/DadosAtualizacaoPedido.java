package com.example.restaurantedanice.domain.pedido;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosAtualizacaoPedido(@NotNull Long id, @NotEmpty List<Long> idComidaList) {
}
