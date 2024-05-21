package com.example.restaurantedanice.application.order;

import com.example.restaurantedanice.infra.food.Food;
import com.example.restaurantedanice.infra.order.Order;
import com.example.restaurantedanice.infra.order.Status;
import com.example.restaurantedanice.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class OrderController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<OrderDetailDTO> novoPedido(@RequestBody @Valid OrderCreateDTO dados, UriComponentsBuilder uriBuilder){

        var dadosDetalhamentoPedido = service.novoPedido(dados);
        var uri = uriBuilder.path("pedido/{id}").buildAndExpand(dadosDetalhamentoPedido.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoPedido);

    }

    @GetMapping
    public ResponseEntity<Page<OrderListDTO>> listarPedidos(@PageableDefault(size = 10, sort = "dataHora", direction = Sort.Direction.DESC) Pageable pageable){
        var page = service.listarPedidos(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("comidas/{id}")
    public ResponseEntity<List<Food>> listarComidasPeloPedido(@PathVariable Long id){

        var lista = service.listarComidasPeloPedido(id);
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Order>> listarPedidoPeloStatus(@PathVariable Status status){

        var pedidos = service.listarPedidosPeloStatus(status);
        return ResponseEntity.ok(pedidos);

    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<OrderDetailDTO> detalharPedido(@PathVariable Long id){

        var dadosDetalhamentoPedido = service.detalharPedido(id);
        return ResponseEntity.ok(dadosDetalhamentoPedido);

    }

    @PutMapping
    public ResponseEntity<OrderDetailDTO> atualizarPedido(@RequestBody @Valid OrderUpdateDTO dados){
        service.atualizarPedido(dados);
        var detalhesPedido = service.detalharPedido(dados.id());
        return ResponseEntity.ok(detalhesPedido);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> concluirPedido(@PathVariable Long id){

        service.concluirPedido(id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPedido(@PathVariable Long id){
        service.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }

}
