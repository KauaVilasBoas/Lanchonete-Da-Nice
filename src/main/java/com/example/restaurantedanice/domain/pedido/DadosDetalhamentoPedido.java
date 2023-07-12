package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.cliente.DadosDetalhamentoCliente;
import com.example.restaurantedanice.domain.comida.DadosDetalhamentoComida;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoPedido(
        Long id,
        DadosDetalhamentoCliente cliente,
        List<DadosDetalhamentoComida> comidas,
        LocalDateTime data_hora,
        Status status) {

    public DadosDetalhamentoPedido(Pedido pedido) {
        this(
                pedido.getId(),
                new DadosDetalhamentoCliente(pedido.getCliente()),
                pedido.getComidas().stream().map(comida -> new DadosDetalhamentoComida(comida)).collect(Collectors.toList()),
                pedido.getData_hora(),
                pedido.getStatus());
    }

}
