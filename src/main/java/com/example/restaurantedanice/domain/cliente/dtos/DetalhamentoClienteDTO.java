package com.example.restaurantedanice.domain.cliente.dtos;

import com.example.restaurantedanice.domain.cliente.Cliente;

public record DetalhamentoClienteDTO(Long id, String nome, String email, String telefone, String cpf, boolean ativo) {

    public DetalhamentoClienteDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.isAtivo());
    }

}
