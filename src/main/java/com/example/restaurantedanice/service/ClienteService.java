package com.example.restaurantedanice.service;

import com.example.restaurantedanice.application.client.ClientUpdateDTO;
import com.example.restaurantedanice.application.client.ClientCreateDTO;
import com.example.restaurantedanice.application.client.ClientDetailDTO;
import com.example.restaurantedanice.application.client.ClientListDTO;
import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.infra.client.ClientRepository;
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
    private ClientRepository clientRepository;

    public ClientDetailDTO cadastrarCliente(ClientCreateDTO dados){

        var cliente = new Client(dados);
        clientRepository.save(cliente);
        return new ClientDetailDTO(cliente);

    }

    public Page<ClientListDTO> listarClientes(Pageable pageable){
        var page = clientRepository.findAllByAtivoTrue(pageable).map(ClientListDTO::new);
        return page;
    }

    public ClientDetailDTO detalharCliente(Long id){

        var cliente = clientRepository.getReferenceById(id);
        return new ClientDetailDTO(cliente);

    }

    public void editarCliente(ClientUpdateDTO dados) throws EntityNotFoundException {

        var cliente = clientRepository.getReferenceById(dados.id());
        if (cliente.equals(null)) throw new EntityNotFoundException();
        cliente.atualizarDados(dados);

    }

    public void excluirCliente(Long id) throws EntityNotFoundException {
        var cliente = clientRepository.getReferenceById(id);
        if (cliente.equals(null)) throw new EntityNotFoundException();
        cliente.setAtivo(false);
    }


}
