package com.example.restaurantedanice.service;

import com.example.restaurantedanice.domain.cliente.*;
import com.example.restaurantedanice.domain.cliente.dtos.AtualizacaoClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.CadastroClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.DetalhamentoClienteDTO;
import com.example.restaurantedanice.domain.cliente.dtos.ListagemClienteDTO;
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

    public DetalhamentoClienteDTO cadastrarCliente(CadastroClienteDTO dados){

        var cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        return new DetalhamentoClienteDTO(cliente);

    }

    public Page<ListagemClienteDTO> listarClientes(Pageable pageable){
        var page = clienteRepository.findAllByAtivoTrue(pageable).map(ListagemClienteDTO::new);
        return page;
    }

    public DetalhamentoClienteDTO detalharCliente(Long id){

        var cliente = clienteRepository.getReferenceById(id);
        return new DetalhamentoClienteDTO(cliente);

    }

    public void editarCliente(AtualizacaoClienteDTO dados) throws EntityNotFoundException {

        var cliente = clienteRepository.getReferenceById(dados.id());
        if (cliente.equals(null)) throw new EntityNotFoundException();
        cliente.atualizarDados(dados);

    }

    public void excluirCliente(Long id) throws EntityNotFoundException {
        var cliente = clienteRepository.getReferenceById(id);
        if (cliente.equals(null)) throw new EntityNotFoundException();
        cliente.setAtivo(false);
    }


}
