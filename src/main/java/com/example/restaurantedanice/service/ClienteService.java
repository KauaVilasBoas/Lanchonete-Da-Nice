package com.example.restaurantedanice.service;

import com.example.restaurantedanice.domain.cliente.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public DadosDetalhamentoCliente cadastrarCliente(DadosCadastroCliente dados){

        var cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        return new DadosDetalhamentoCliente(cliente);

    }

    public Page<DadosListagemCliente> listarClientes(Pageable pageable){
        var page = clienteRepository.findAll(pageable).map(DadosListagemCliente::new);
        return page;
    }

    public DadosDetalhamentoCliente detalharCliente(Long id){

        var cliente = clienteRepository.getReferenceById(id);
        return new DadosDetalhamentoCliente(cliente);

    }

    public void editarCliente(DadosAtualizacaoCliente dados) throws EntityNotFoundException {

        var cliente = clienteRepository.getReferenceById(dados.id());
        if (cliente.equals(null)) throw new EntityNotFoundException();
        cliente.atualizarDados(dados);

    }

    public void excluirCliente(Long id) throws EntityNotFoundException {
        var cliente = clienteRepository.getReferenceById(id);
        if (cliente.equals(null)) throw new EntityNotFoundException();
        clienteRepository.delete(cliente);
    }


}
