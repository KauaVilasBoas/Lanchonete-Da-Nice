package com.example.restaurantedanice.application.food;

import com.example.restaurantedanice.infra.food.Food;

public record FoodListDTO(Long id, String titulo, String imagem, Double preco, boolean ativo) {

    public FoodListDTO(Food food){
        this(food.getId(), food.getTitulo(), food.getImagem(), food.getPreco(), food.isAtivo());
    }

}
