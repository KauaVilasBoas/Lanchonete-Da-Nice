package com.example.restaurantedanice.application.order;

import com.example.restaurantedanice.application.client.ClientDetailDTO;
import com.example.restaurantedanice.application.food.FoodDetailDTO;
import com.example.restaurantedanice.infra.order.Order;
import com.example.restaurantedanice.infra.order.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record OrderDetailDTO(
        Long id,
        ClientDetailDTO cliente,
        List<FoodDetailDTO> comidas,
        LocalDateTime data_hora,
        Status status,
        boolean ativo,
        Double precoTotal) {

    public OrderDetailDTO(Order order) {
        this(
                order.getId(),
                new ClientDetailDTO(order.getClient()),
                order.getFoods().stream().map(FoodDetailDTO::new).collect(Collectors.toList()),
                order.getDataHora(),
                order.getStatus(),
                order.isAtivo(),
                order.getPrecoTotal());

    }

}
