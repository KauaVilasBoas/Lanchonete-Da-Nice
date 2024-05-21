package com.example.restaurantedanice.application.order;

import com.example.restaurantedanice.infra.client.ClientRepository;
import com.example.restaurantedanice.infra.food.Food;
import com.example.restaurantedanice.infra.food.FoodRepository;
import com.example.restaurantedanice.infra.order.Order;
import com.example.restaurantedanice.infra.order.OrderRepository;
import com.example.restaurantedanice.infra.order.Status;
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
public class OrderService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderDetailDTO novoPedido(OrderCreateDTO dados) throws EntityNotFoundException {

        var cliente = clientRepository.getReferenceById(dados.idCliente());

        if (cliente.equals(null)) throw new EntityNotFoundException();

        List<Food> foodList = new ArrayList<>();

        for (Long id_comida :
                dados.idComidaList()) {

            if (id_comida != null) {
                foodList.add(foodRepository.getReferenceById(id_comida));
            }

        }

        var pedido = new Order(cliente, foodList);
        orderRepository.save(pedido);

        return new OrderDetailDTO(pedido);
    }

    public void excluirPedido(Long id) throws EntityNotFoundException {

        var pedido = orderRepository.getReferenceById(id);

        if (pedido.equals(null)) throw new EntityNotFoundException();

        pedido.setAtivo(false);
        pedido.setStatus(Status.CANCELADO);

    }

    public Page<OrderListDTO> listarPedidos(Pageable pageable) {
        var page = orderRepository.findAll(pageable).map(OrderListDTO::new);
        return page;
    }

    public List<Food> listarComidasPeloPedido(Long id) {

        var comidas = orderRepository.findComidasByPedidoId(id);

        return comidas;
    }

    public void concluirPedido(Long id) {

        var pedido = orderRepository.getReferenceById(id);
        pedido.setStatus(Status.ENTREGUE);

    }

    public List<Order> listarPedidosPeloStatus(Status status) {

        var pedidos = orderRepository.findAllByStatusEquals(status);
        return pedidos;

    }

    public void atualizarPedido(OrderUpdateDTO dados) {

        var pedido = orderRepository.getReferenceById(dados.id());

        var lista = dados.idComidaList();

        var listaComidas = new ArrayList<Food>();

        for (Long idComida:
             lista) {

            listaComidas.add(foodRepository.getReferenceById(idComida));

        }

        pedido.setFoods(listaComidas);
        pedido.setPrecoTotal(listaComidas.stream().mapToDouble(Food::getPreco).sum());

    }

    public OrderDetailDTO detalharPedido(Long id) {
        var pedido = orderRepository.getReferenceById(id);
        return new OrderDetailDTO(pedido);
    }
}
