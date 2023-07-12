package com.example.restaurantedanice.domain.comida;

public record DadosListagemComida(Long id, String titulo, String imagem, Double preco) {

    public DadosListagemComida(Comida comida){
        this(comida.getId(), comida.getTitulo(), comida.getImagem(), comida.getPreco());
    }

}
