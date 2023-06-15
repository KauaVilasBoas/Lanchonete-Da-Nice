package com.example.restaurantedanice.controller;

import com.example.restaurantedanice.domain.comida.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comida")
public class ComidaController {

    @Autowired
    private ComidaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroComida dados){

        var comida = new Comida(dados);

        repository.save(comida);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhamentoComida(comida));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemComida>> getAll(@PageableDefault(size = 10, sort ={"nome"}) Pageable pageable){

        var page = repository.findAll(pageable).map(DadosListagemComida::new);
        return ResponseEntity.ok(page);

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){

        var comida  = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoComida(comida));

    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoComida dados){
        var comida = repository.getReferenceById(dados.id());
        comida.atualizarDados(dados);
        return ResponseEntity.ok("Dados atualizados!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var comida = repository.getReferenceById(id);
        repository.delete(comida);
        return ResponseEntity.noContent().build();
    }

}
