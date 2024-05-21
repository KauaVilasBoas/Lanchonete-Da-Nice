package com.example.restaurantedanice.application.order;

import com.example.restaurantedanice.application.food.FoodDetailDTO;
import com.example.restaurantedanice.infra.order.Order;
import com.example.restaurantedanice.infra.order.Status;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public record OrderListDTO(

        Long id,
        String nomeCliente,
        String data_hora,
        List<FoodDetailDTO> comidaList,
        Status status,
        Double precoTotal

) {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public OrderListDTO(Order order) {
        this(order.getId(),
                order.getClient().getNome(),
                order.getDataHora().format(formatter),
                order.getFoods().stream().map(FoodDetailDTO::new).collect(Collectors.toList()),
                order.getStatus(),
                order.getPrecoTotal());
    }

}
