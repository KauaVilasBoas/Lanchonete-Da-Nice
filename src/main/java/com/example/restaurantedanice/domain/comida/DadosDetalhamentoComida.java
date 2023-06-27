package com.example.restaurantedanice.domain.comida;

public record DadosDetalhamentoComida(Long id, String titulo, String imagem, Double preco) {
    public DadosDetalhamentoComida(Comida comida){
        this(comida.getId(), comida.getTitulo(), comida.getImagem(), comida.getPreco());
    }

}
