package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.comida.dtos.AtualizacaoComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.CadastroComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.ListagemComidaDTO;
import com.example.restaurantedanice.service.ComidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/comidas")
public class ComidaController {

    @Autowired
    private ComidaService service;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid CadastroComidaDTO dados, UriComponentsBuilder uriBuilder) {

        var dadosDetalhamentoComida = service.cadastrarComida(dados);
        var uri = uriBuilder.path("/comida/{id}").buildAndExpand(dadosDetalhamentoComida.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoComida);

    }

    @GetMapping
    public ResponseEntity<Page<ListagemComidaDTO>> getAll(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable) {

        var page = service.listarComidas(pageable);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var detalhamentoComida = service.detalharComida(id);
        return ResponseEntity.ok(detalhamentoComida);

    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoComidaDTO dados) {
        service.atualizarComida(dados);
        return ResponseEntity.ok("Dados atualizados!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluirComida(id);
        return ResponseEntity.noContent().build();
    }

}
