package com.example.restaurantedanice.domain.comida.dtos;

import com.example.restaurantedanice.domain.comida.Comida;

public record ListagemComidaDTO(Long id, String titulo, String imagem, Double preco) {

    public ListagemComidaDTO(Comida comida){
        this(comida.getId(), comida.getTitulo(), comida.getImagem(), comida.getPreco());
    }

}
