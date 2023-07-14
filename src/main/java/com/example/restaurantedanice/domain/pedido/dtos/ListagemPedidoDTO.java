package com.example.restaurantedanice.domain.pedido.dtos;

import com.example.restaurantedanice.domain.comida.Comida;
import com.example.restaurantedanice.domain.pedido.Pedido;
import com.example.restaurantedanice.domain.pedido.Status;

import java.time.LocalDateTime;
import java.util.List;

public record ListagemPedidoDTO(

        Long id,
        String nomeCliente,
        LocalDateTime data_hora,
        List<Comida> comidaList,
        Status status,
        boolean ativo

) {


    public ListagemPedidoDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getCliente().getNome(), pedido.getData_hora(), pedido.getComidas(), pedido.getStatus(), pedido.isAtivo());
    }

}
