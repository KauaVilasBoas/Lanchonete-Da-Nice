package com.example.restaurantedanice.domain.food;

import com.example.restaurantedanice.application.food.FoodUpdateDTO;

import java.util.UUID;

public class Food {

    private UUID id;
    private String title;
    private String imageURL;
    private Double price;
    private boolean active;

    public Food() {
        this.id = UUID.randomUUID();
        active();
    }
    public Food(String title, String imageURL, Double price) {
        this.title = title;
        this.imageURL = imageURL;
        this.price = price;
    }

    public void active(){
        this.active = true;
    }

    public void atualizarDados(FoodUpdateDTO dados) {

        if (dados.titulo() != null) {
            this.title = dados.titulo();
        }
        if (dados.imagem() != null) {
            this.imageURL = dados.imagem();
        }
        if (dados.preco() != null) {
            this.price = dados.preco();
        }


    }
}
