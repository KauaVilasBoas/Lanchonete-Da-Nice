package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.comida.DadosAtualizacaoComida;
import com.example.restaurantedanice.domain.comida.DadosCadastroComida;
import com.example.restaurantedanice.domain.comida.DadosDetalhamentoComida;
import com.example.restaurantedanice.domain.comida.DadosListagemComida;
import com.example.restaurantedanice.service.ComidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    private ComidaService service;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroComida dados) {

        var dadosDetalhamentoComida = service.cadastrarComida(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(dadosDetalhamentoComida);

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemComida>> getAll(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable) {

        var page = service.listarComidas(pageable);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var detalhamentoComida = service.detalharComida(id);
        return ResponseEntity.ok(detalhamentoComida);

    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoComida dados) {
        service.atualizarComida(dados);
        return ResponseEntity.ok("Dados atualizados!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluirComida(id);
        return ResponseEntity.noContent().build();
    }

}
