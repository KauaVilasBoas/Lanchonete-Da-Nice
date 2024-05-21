package com.example.restaurantedanice.domain.order;

import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.infra.food.Food;
import com.example.restaurantedanice.infra.order.Status;

import java.time.LocalDateTime;
import java.util.List;
public class IOrder {

    private Long id;
    private Client client;
    private List<Food> foods;
    private LocalDateTime dateTime;
    private Status status;
    private boolean active;
    private Double totalPrice;

    public IOrder(Client client, List<Food> comidasList) {

        this.client = client;
        this.foods = comidasList;
        this.dateTime = LocalDateTime.now();
        this.status = Status.PREPARANDO;
        this.active = true;
        this.totalPrice = comidasList.stream().mapToDouble(Food::getPreco).sum();

    }


}
