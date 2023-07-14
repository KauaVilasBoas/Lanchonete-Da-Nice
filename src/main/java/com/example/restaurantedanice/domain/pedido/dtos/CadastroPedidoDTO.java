package com.example.restaurantedanice.domain.pedido.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CadastroPedidoDTO(@NotNull Long idCliente, @NotNull List<Long> idComidaList) {
}
