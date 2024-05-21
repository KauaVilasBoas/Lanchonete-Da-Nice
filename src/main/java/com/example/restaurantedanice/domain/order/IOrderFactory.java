package com.example.restaurantedanice.domain.order;

import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.infra.food.Food;

import java.util.List;

public interface IOrderFactory {

    public IOrder create(Client client, List<Food> comidasList);

}
