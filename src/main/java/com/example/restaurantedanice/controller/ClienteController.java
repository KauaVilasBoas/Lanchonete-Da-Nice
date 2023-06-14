package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.cliente.Cliente;
import com.example.restaurantedanice.domain.cliente.ClienteRepository;
import com.example.restaurantedanice.domain.cliente.DadosCadastroCliente;
import com.example.restaurantedanice.domain.cliente.DadosDetalhamentoCliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        var cliente = clienteRepository.getReferenceById(id);

        clienteRepository.delete(cliente);

        return ResponseEntity.noContent().build();
    }

}


