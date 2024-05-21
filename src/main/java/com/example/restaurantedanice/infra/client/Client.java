package com.example.restaurantedanice.infra.client;

import com.example.restaurantedanice.application.client.ClientUpdateDTO;
import com.example.restaurantedanice.application.client.ClientCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo;

    public Client(ClientCreateDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.ativo = true;
    }

    public void atualizarDados(ClientUpdateDTO dados) {

        if (dados.nome()!=null){
            this.nome = dados.nome();
        }
        if (dados.telefone()!=null){
            this.telefone = dados.telefone();
        }

    }
}

