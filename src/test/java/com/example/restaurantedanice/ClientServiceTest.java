package com.example.restaurantedanice;

import com.example.restaurantedanice.application.client.ClientController;
import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.application.client.ClientCreateDTO;
import com.example.restaurantedanice.application.client.ClientDetailDTO;
import com.example.restaurantedanice.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
class ClientServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientController clientController;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void aoCadastrarComDadosCorretosDeveRetornarDetalhamentoClienteDTO() throws Exception {

        ClientCreateDTO clientCreateDTO = new ClientCreateDTO("Kauã", "kaua@test.com", "71999884455", "");

        Client client = new Client(clientCreateDTO);

        when(clienteService.cadastrarCliente(any(ClientCreateDTO.class)))
                .thenReturn(new ClientDetailDTO(client));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/clientes")
                        .content(asJsonString(clientCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        Mockito.verify(clienteService, Mockito.times(1)).cadastrarCliente(any(ClientCreateDTO.class));

        String locationHeader = result.getResponse().getHeader("Location");

        assertNotNull(locationHeader, "O Header não pode ser vazio");
        assert(locationHeader).contains("/clientes/");
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void aoCadastrarComDadosFaltantesDeveRetornarStatusBadRequest() throws Exception {
        // Dados com campos em branco
        ClientCreateDTO dados = new ClientCreateDTO(
                "",    // Nome em branco
                "",    // Email em branco
                "1234567890",
                "123.456.789-10"
        );

        mvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dados))
                )
                .andExpect(status().isBadRequest()); // Verifica se o status é 400 Bad Request
    }

}
