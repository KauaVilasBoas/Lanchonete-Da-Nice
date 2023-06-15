package com.example.restaurantedanice.domain.comida;

public record DadosListagemComida(String titulo, String imagem, Double preco) {

    public DadosListagemComida(Comida comida){
        this(comida.getTitulo(), comida.getImagem(), comida.getPreco());
    }

}
