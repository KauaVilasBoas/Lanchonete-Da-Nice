package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.cliente.dtos.AtualizacaoClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.CadastroClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.DetalhamentoClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.ListagemClienteDTO;
import com.example.restaurantedanice.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<DetalhamentoClienteDTO> cadastrar(@RequestBody @Valid CadastroClienteDTO dados, UriComponentsBuilder uriBuilder){

        var dadosDetalhamentoCliente = service.cadastrarCliente(dados);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(dadosDetalhamentoCliente.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoCliente);

    }

    @GetMapping
    public ResponseEntity<Page<ListagemClienteDTO>> getAll(@PageableDefault(size = 10, sort ={"nome"}) Pageable pageable){
        var page = service.listarClientes(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoClienteDTO> detalhar(@PathVariable Long id){
        var dadosDetalhamentoCliente = service.detalharCliente(id);
        return ResponseEntity.ok(dadosDetalhamentoCliente);
    }

    @PutMapping
    public ResponseEntity<DetalhamentoClienteDTO> editar(@RequestBody AtualizacaoClienteDTO dados){

        service.editarCliente(dados);
        var detalhesDoCliente = service.detalharCliente(dados.id());
        return ResponseEntity.ok(detalhesDoCliente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id){

        service.excluirCliente(id);
        return ResponseEntity.noContent().build();

    }

}


