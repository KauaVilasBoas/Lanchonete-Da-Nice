package com.example.restaurantedanice.domain.pedido.dtos;

import com.example.restaurantedanice.domain.cliente.dtos.DetalhamentoClienteDTO;
import com.example.restaurantedanice.domain.comida.dtos.DetalhamentoComidaDTO;
import com.example.restaurantedanice.domain.pedido.Pedido;
import com.example.restaurantedanice.domain.pedido.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DetalhamentoPedidoDTO(
        Long id,
        DetalhamentoClienteDTO cliente,
        List<DetalhamentoComidaDTO> comidas,
        LocalDateTime data_hora,
        Status status,
        boolean ativo,
        Double precoTotal) {

    public DetalhamentoPedidoDTO(Pedido pedido) {
        this(
                pedido.getId(),
                new DetalhamentoClienteDTO(pedido.getCliente()),
                pedido.getComidas().stream().map(DetalhamentoComidaDTO::new).collect(Collectors.toList()),
                pedido.getDataHora(),
                pedido.getStatus(),
                pedido.isAtivo(),
                pedido.getPrecoTotal());

    }

}
