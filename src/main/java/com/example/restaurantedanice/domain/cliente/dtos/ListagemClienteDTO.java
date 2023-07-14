package com.example.restaurantedanice.domain.cliente.dtos;

import com.example.restaurantedanice.domain.cliente.Cliente;

public record ListagemClienteDTO(Long id, String nome, String email, String telefone, boolean ativo) {

    public ListagemClienteDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.isAtivo());
    }

}
