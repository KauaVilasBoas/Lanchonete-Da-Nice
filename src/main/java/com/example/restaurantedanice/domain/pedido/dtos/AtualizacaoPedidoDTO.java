package com.example.restaurantedanice.domain.pedido.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AtualizacaoPedidoDTO(@NotNull Long id, @NotEmpty List<Long> idComidaList) {
}
