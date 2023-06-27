package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.comida.Comida;
import com.example.restaurantedanice.domain.comida.ComidaRepository;
import com.example.restaurantedanice.domain.comida.DadosListagemComida;
import com.example.restaurantedanice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public record DadosListagemPedido(

        Long id,
        String nomeCliente,
        LocalDateTime data_hora,
        List<Long> comidaList,
        Status status

) {

    private static ComidaRepository comidaRepository;

    public DadosListagemPedido(Pedido pedido) {
        this(pedido.getId(), pedido.getCliente().getNome(), pedido.getData_hora(), comidaRepository.pegarTodasAsComidasPeloIdDoPedido(pedido.getId()), pedido.getStatus());
    }

}
