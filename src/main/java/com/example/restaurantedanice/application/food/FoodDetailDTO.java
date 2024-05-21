package com.example.restaurantedanice.application.food;

import com.example.restaurantedanice.infra.food.Food;

public record FoodDetailDTO(Long id, String titulo, String imagem, Double preco, boolean ativo) {
    public FoodDetailDTO(Food food){
        this(food.getId(), food.getTitulo(), food.getImagem(), food.getPreco(), food.isAtivo());
    }

}
