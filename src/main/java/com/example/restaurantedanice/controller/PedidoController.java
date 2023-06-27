package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.pedido.DadosCadastroPedido;
import com.example.restaurantedanice.domain.pedido.DadosListagemPedido;
import com.example.restaurantedanice.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping("/novoPedido")
    public ResponseEntity novoPedido(@RequestBody @Valid DadosCadastroPedido dados){

        System.out.println(dados.idCliente());
        System.out.println(dados.idComidaList());

        service.novoPedido(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("listarTodos")
    public ResponseEntity<Page<DadosListagemPedido>> listarPedidos(@PageableDefault(size = 10) Pageable pageable){
        var page = service.listarPedidos(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

//    @GetMapping("/filtrar/{status}")
//    public ResponseEntity filtrarPorStatus(@PathVariable String string){
//        service.filtrarPorStatus(string);
//
//    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity excluirPedido(@PathVariable Long id){
        service.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }

}
