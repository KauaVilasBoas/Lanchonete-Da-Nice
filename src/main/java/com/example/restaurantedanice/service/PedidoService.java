package com.example.restaurantedanice.service;

import com.example.restaurantedanice.domain.cliente.ClienteRepository;
import com.example.restaurantedanice.domain.comida.Comida;
import com.example.restaurantedanice.domain.comida.ComidaRepository;
import com.example.restaurantedanice.domain.pedido.*;
import com.example.restaurantedanice.domain.pedido.dtos.AtualizacaoPedidoDTO;
import com.example.restaurantedanice.domain.pedido.dtos.CadastroPedidoDTO;
import com.example.restaurantedanice.domain.pedido.dtos.DetalhamentoPedidoDTO;
import com.example.restaurantedanice.domain.pedido.dtos.ListagemPedidoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComidaRepository comidaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public DetalhamentoPedidoDTO novoPedido(CadastroPedidoDTO dados) throws EntityNotFoundException {

        var cliente = clienteRepository.getReferenceById(dados.idCliente());

        if (cliente.equals(null)) throw new EntityNotFoundException();

        List<Comida> comidaList = new ArrayList<>();

        for (Long id_comida :
                dados.idComidaList()) {

            if (id_comida != null) {
                comidaList.add(comidaRepository.getReferenceById(id_comida));
            }

        }

        var pedido = new Pedido(cliente, comidaList);
        pedidoRepository.save(pedido);

        return new DetalhamentoPedidoDTO(pedido);
    }

    public void excluirPedido(Long id) throws EntityNotFoundException {

        var pedido = pedidoRepository.getReferenceById(id);

        if (pedido.equals(null)) throw new EntityNotFoundException();

        pedido.setAtivo(false);
        pedido.setStatus(Status.CANCELADO);

    }

    public Page<ListagemPedidoDTO> listarPedidos(Pageable pageable) {
        var page = pedidoRepository.findAll(pageable).map(ListagemPedidoDTO::new);
        return page;
    }

    public List<Comida> listarComidasPeloPedido(Long id) {

        var comidas = pedidoRepository.findComidasByPedidoId(id);

        return comidas;
    }

    public void concluirPedido(Long id) {

        var pedido = pedidoRepository.getReferenceById(id);
        pedido.setStatus(Status.ENTREGUE);

    }

    public List<Pedido> listarPedidosPeloStatus(Status status) {

        var pedidos = pedidoRepository.findAllByStatusEquals(status);
        return pedidos;

    }

    public void atualizarPedido(AtualizacaoPedidoDTO dados) {

        var pedido = pedidoRepository.getReferenceById(dados.id());

        var lista = dados.idComidaList();

        var listaComidas = new ArrayList<Comida>();

        for (Long idComida:
             lista) {

            listaComidas.add(comidaRepository.getReferenceById(idComida));

        }

        pedido.setComidas(listaComidas);
        pedido.setPrecoTotal(listaComidas.stream().mapToDouble(Comida::getPreco).sum());

    }

    public DetalhamentoPedidoDTO detalharPedido(Long id) {
        var pedido = pedidoRepository.getReferenceById(id);
        return new DetalhamentoPedidoDTO(pedido);
    }
}
