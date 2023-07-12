package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.comida.Comida;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemPedido(

        Long id,
        String nomeCliente,
        LocalDateTime data_hora,
        List<Comida> comidaList,
        Status status

) {


    public DadosListagemPedido(Pedido pedido) {
        this(pedido.getId(), pedido.getCliente().getNome(), pedido.getData_hora(), pedido.getComidas(), pedido.getStatus());
    }

}
