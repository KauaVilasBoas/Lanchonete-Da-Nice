package com.example.restaurantedanice.domain.cliente;

import com.example.restaurantedanice.domain.cliente.dtos.AtualizacaoClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.CadastroClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public Cliente(CadastroClienteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
    }

    public void atualizarDados(AtualizacaoClienteDTO dados) {

        if (dados.nome()!=null){
            this.nome = dados.nome();
        }
        if (dados.telefone()!=null){
            this.telefone = dados.telefone();
        }

    }
}

