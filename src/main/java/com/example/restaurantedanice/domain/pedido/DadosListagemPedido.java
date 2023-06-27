package com.example.restaurantedanice.domain.pedido;

import java.time.LocalDateTime;

public record DadosListagemPedido(

        Long id,
        String nomeCliente,
        LocalDateTime data_hora,
        Status status

) {


    public DadosListagemPedido(Pedido pedido) {
        this(pedido.getId(), pedido.getCliente().getNome(), pedido.getData_hora(), pedido.getStatus());
    }

}
