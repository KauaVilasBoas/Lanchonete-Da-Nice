package com.example.restaurantedanice.domain.cliente;

public record DadosDetalhamentoCliente(Long id, String nome, String email, String telefone, String cpf) {

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf());
    }

}
