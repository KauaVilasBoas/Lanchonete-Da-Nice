package com.example.restaurantedanice.service;

import com.example.restaurantedanice.domain.comida.*;
import com.example.restaurantedanice.domain.comida.dtos.AtualizacaoComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.CadastroComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.DetalhamentoComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.ListagemComidaDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComidaService {

    @Autowired
    private ComidaRepository repository;

    //C.R.U.D

    public DetalhamentoComidaDTO cadastrarComida(CadastroComidaDTO dados){

        var comida = new Comida(dados);
        repository.save(comida);
        var dadosDetalhamentoComida = new DetalhamentoComidaDTO(comida);
        return dadosDetalhamentoComida;

    }

    public Page<ListagemComidaDTO> listarComidas(Pageable pageable){

        var page = repository.findAllByAtivoTrue(pageable).map(ListagemComidaDTO::new);
        return page;

    }

    public DetalhamentoComidaDTO detalharComida(Long id){

        var comida = repository.getReferenceById(id);
        var dadosDetalhamentoComida = new DetalhamentoComidaDTO(comida);
        return dadosDetalhamentoComida;

    }

    public void atualizarComida(AtualizacaoComidaDTO dados){

        var comida = repository.getReferenceById(dados.id());
        comida.atualizarDados(dados);

    }

    public void excluirComida(Long id) throws EntityNotFoundException{
        var comida = repository.getReferenceById(id);
        if (comida.equals(null)){
            throw new EntityNotFoundException();
        }
        comida.setAtivo(false);
    }



}
