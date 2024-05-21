package com.example.restaurantedanice.application.client;

import com.example.restaurantedanice.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClientDetailDTO> cadastrar(@RequestBody @Valid ClientCreateDTO dados, UriComponentsBuilder uriBuilder){

        var dadosDetalhamentoCliente = service.cadastrarCliente(dados);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(dadosDetalhamentoCliente.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoCliente);

    }

    @GetMapping
    public ResponseEntity<Page<ClientListDTO>> getAll(@PageableDefault(size = 10, sort ={"nome"}) Pageable pageable){
        var page = service.listarClientes(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDetailDTO> detalhar(@PathVariable Long id){
        var dadosDetalhamentoCliente = service.detalharCliente(id);
        return ResponseEntity.ok(dadosDetalhamentoCliente);
    }

    @PutMapping
    public ResponseEntity<ClientDetailDTO> editar(@RequestBody ClientUpdateDTO dados){

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


