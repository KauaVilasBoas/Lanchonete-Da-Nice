package com.example.restaurantedanice.service;

import com.example.restaurantedanice.domain.cliente.ClienteRepository;
import com.example.restaurantedanice.domain.comida.Comida;
import com.example.restaurantedanice.domain.comida.ComidaRepository;
import com.example.restaurantedanice.domain.pedido.DadosCadastroPedido;
import com.example.restaurantedanice.domain.pedido.DadosListagemPedido;
import com.example.restaurantedanice.domain.pedido.Pedido;
import com.example.restaurantedanice.domain.pedido.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido novoPedido(DadosCadastroPedido dados) throws EntityNotFoundException{

        var cliente = clienteRepository.getReferenceById(dados.idCliente());

        if (cliente.equals(null)) throw new EntityNotFoundException();

        List<Comida> comidaList = new ArrayList<>();

        for (Long id_comida:
                dados.idComidaList()) {

            if (id_comida != null){
                comidaList.add(comidaRepository.getReferenceById(id_comida));
            }

        }

        var pedido = new Pedido(cliente, comidaList);
        pedidoRepository.save(pedido);

        return pedido;
    }

    public void excluirPedido(Long id) throws EntityNotFoundException {

        var pedido = pedidoRepository.getReferenceById(id);

        if (pedido.equals(null)) throw new EntityNotFoundException();

        pedidoRepository.delete(pedido);

    }

    public Page<DadosListagemPedido> listarPedidos(Pageable pageable) {
        var page = pedidoRepository.findAll(pageable).map(DadosListagemPedido::new);
        return page;
    }
}
