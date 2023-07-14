package com.example.restaurantedanice.domain.comida.dtos;

import com.example.restaurantedanice.domain.comida.Comida;

public record DetalhamentoComidaDTO(Long id, String titulo, String imagem, Double preco, boolean ativo) {
    public DetalhamentoComidaDTO(Comida comida){
        this(comida.getId(), comida.getTitulo(), comida.getImagem(), comida.getPreco(), comida.isAtivo());
    }

}
