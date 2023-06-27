package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.cliente.Cliente;

import java.time.LocalDateTime;

public record DadosListagemPedido(

        Long id,
        Cliente cliente,
        LocalDateTime data_hora,
        Status status

) {

    public DadosListagemPedido(Pedido pedido) {
        this(pedido.getId(), pedido.getCliente(), pedido.getData_hora(), pedido.getStatus());
    }


}
