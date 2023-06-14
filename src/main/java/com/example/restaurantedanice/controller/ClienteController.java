package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados){

        var cliente = new Cliente(dados);

        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> getAll(@PageableDefault(size = 10, sort ={"nome"}) Pageable pageable){
        var page = clienteRepository.findAll(pageable).map(DadosListagemCliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity editar(@RequestBody DadosAtualizacaoCliente dados){

        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarDados(dados);
        return ResponseEntity.ok("Dados atualizados!");

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        var cliente = clienteRepository.getReferenceById(id);

        clienteRepository.delete(cliente);

        return ResponseEntity.noContent().build();
    }

}


