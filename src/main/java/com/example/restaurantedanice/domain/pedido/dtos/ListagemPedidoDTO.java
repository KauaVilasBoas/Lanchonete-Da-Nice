package com.example.restaurantedanice.domain.pedido.dtos;

import com.example.restaurantedanice.domain.comida.dtos.DetalhamentoComidaDTO;
import com.example.restaurantedanice.domain.pedido.Pedido;
import com.example.restaurantedanice.domain.pedido.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public record ListagemPedidoDTO(

        Long id,
        String nomeCliente,
        String data_hora,
        List<DetalhamentoComidaDTO> comidaList,
        Status status,
        boolean ativo,
        Double precoTotal

) {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public ListagemPedidoDTO(Pedido pedido) {
        this(pedido.getId(),
                pedido.getCliente().getNome(),
                pedido.getData_hora().format(formatter),
                pedido.getComidas().stream().map(DetalhamentoComidaDTO::new).collect(Collectors.toList()),
                pedido.getStatus(),
                pedido.isAtivo(),
                pedido.getPrecoTotal());
    }

}
