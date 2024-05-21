package com.example.restaurantedanice.application.client;

import com.example.restaurantedanice.infra.client.Client;

public record ClientListDTO(Long id, String nome, String email, String telefone, boolean ativo) {

    public ClientListDTO(Client client){
        this(client.getId(), client.getNome(), client.getEmail(), client.getTelefone(), client.isAtivo());
    }

}
