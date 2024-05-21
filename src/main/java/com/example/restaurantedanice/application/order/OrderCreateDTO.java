package com.example.restaurantedanice.application.order;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderCreateDTO(@NotNull Long idCliente, @NotNull List<Long> idComidaList) {
}
