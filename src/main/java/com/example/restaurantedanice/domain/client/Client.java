package com.example.restaurantedanice.domain.client;

import com.example.restaurantedanice.application.client.ClientUpdateDTO;

import java.util.UUID;

public class Client {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    private boolean active;

    public Client() {
        this.id = UUID.randomUUID();
        active();
    }

    public Client(String name, String email, String phone, String cpf) {
        this();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
    }

    public void active(){
        this.active = true;
    }

    public void atualizarDados(ClientUpdateDTO dados) {

        if (dados.nome()!=null){
            this.name = dados.nome();
        }
        if (dados.telefone()!=null){
            this.phone = dados.telefone();
        }

    }
}

