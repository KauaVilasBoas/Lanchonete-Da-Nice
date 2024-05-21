package com.example.restaurantedanice.application.client;

import com.example.restaurantedanice.infra.client.Client;

public record ClientDetailDTO(Long id, String nome, String email, String telefone, String cpf, boolean ativo) {

    public ClientDetailDTO(Client client){
        this(client.getId(), client.getNome(), client.getEmail(), client.getTelefone(), client.getCpf(), client.isAtivo());
    }

}
