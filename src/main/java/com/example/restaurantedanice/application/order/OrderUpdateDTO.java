package com.example.restaurantedanice.application.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderUpdateDTO(@NotNull Long id, @NotEmpty List<Long> idComidaList) {
}
