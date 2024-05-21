package com.example.restaurantedanice.application.food;

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
public class FoodController {

    @Autowired
    private FoodService service;

    @PostMapping
    public ResponseEntity<FoodDetailDTO> cadastro(@RequestBody @Valid FoodCreateDTO dados, UriComponentsBuilder uriBuilder) {

        var dadosDetalhamentoComida = service.cadastrarComida(dados);
        var uri = uriBuilder.path("/comida/{id}").buildAndExpand(dadosDetalhamentoComida.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoComida);

    }

    @GetMapping
    public ResponseEntity<Page<FoodListDTO>> getAll(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable) {

        var page = service.listarComidas(pageable);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDetailDTO> detalhar(@PathVariable Long id) {

        var detalhamentoComida = service.detalharComida(id);
        return ResponseEntity.ok(detalhamentoComida);

    }

    @PutMapping
    public ResponseEntity<FoodDetailDTO> atualizar(@RequestBody @Valid FoodUpdateDTO dados) {
        service.atualizarComida(dados);
        var detalhamentoComida = service.detalharComida(dados.id());
        return ResponseEntity.ok(detalhamentoComida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        service.excluirComida(id);
        return ResponseEntity.noContent().build();
    }

}
