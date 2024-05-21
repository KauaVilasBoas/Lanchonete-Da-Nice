package com.example.restaurantedanice.domain.order;

import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.infra.food.Food;

import java.util.List;

public class OrderFactory implements IOrderFactory{
    @Override
    public IOrder create(Client client, List<Food> comidasList) {
        // adicionar validações de criação
        IOrder order = new IOrder(client, comidasList);

        return order;
    }
}
