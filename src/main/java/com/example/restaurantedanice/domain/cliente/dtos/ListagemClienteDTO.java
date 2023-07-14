package com.example.restaurantedanice.domain.cliente.dtos;

import com.example.restaurantedanice.domain.cliente.Cliente;

public record ListagemClienteDTO(Long id, String nome, String email, String telefone) {

    public ListagemClienteDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }

}
