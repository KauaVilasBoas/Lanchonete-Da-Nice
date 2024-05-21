package com.example.restaurantedanice.domain.order;

import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.infra.food.Food;
import com.example.restaurantedanice.infra.order.Status;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.List;
public class Order implements OrderFactory{

    private Long id;
    private Client client;
    private List<Food> foods;
    private LocalDateTime dateTime;
    private Status status;
    private boolean active;
    private Double totalPrice;

    public Order(Client client, List<Food> comidasList) {

        this.client = client;
        this.foods = comidasList;
        this.dateTime = LocalDateTime.now();
        this.status = Status.PREPARANDO;
        this.active = true;
        this.totalPrice = comidasList.stream().mapToDouble(Food::getPreco).sum();

    }

    @Override
    public Order create(Client client, List<Food> comidasList) {
        // adicionar validações de criação
        Order order = new Order(client, comidasList);

        return order;
    }
}
