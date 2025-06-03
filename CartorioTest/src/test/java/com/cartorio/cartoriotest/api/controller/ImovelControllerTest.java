package com.cartorio.cartoriotest.api.controller;

import com.cartorio.cartoriotest.api.dto.ImoveisDTO;
import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoImoveis;
import com.cartorio.cartoriotest.domain.model.Imoveis;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelImoveis;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ImovelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartorioRepositoryModelImoveis repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        Imoveis imovel = new Imoveis(
                UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                "Imóvel Teste",
                "Rua Exemplo, 123",
                "123456789",
                TipoDocumentoImoveis.IPTU,
                StatusOk.APROVADO
        );
        repository.save(imovel);
    }

    @Test
    void deveRetornarListaDeImoveisComStatus200() throws Exception {
        mockMvc.perform(get("/imoveis")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Imóvel Teste"))
                .andExpect(jsonPath("$[0].endereco").value("Rua Exemplo, 123"))
                .andExpect(jsonPath("$[0].cep").value("123456789"))
                .andExpect(jsonPath("$[0].tipoDocumentoImoveis").value("IPTU"))
                .andExpect(jsonPath("$[0].statusOk").value("APROVADO"));
    }

    @Test
    void deveCriarNovoImovelERetornarStatus201() throws Exception {
        ImoveisDTO dto = new ImoveisDTO();
        dto.setNome("Novo Imóvel");
        dto.setEndereco("Rua Nova, 456");
        dto.setCep("987654321");
        dto.setTipoDocumentoImoveis(TipoDocumentoImoveis.IPTU);
        dto.setStatusOk(StatusOk.APROVADO);

        String json = new ObjectMapper().writeValueAsString(dto);

        mockMvc.perform(post("/imoveis")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Novo Imóvel"))
                .andExpect(jsonPath("$.endereco").value("Rua Nova, 456"))
                .andExpect(jsonPath("$.cep").value("987654321"))
                .andExpect(jsonPath("$.tipoDocumentoImoveis").value("IPTU"))
                .andExpect(jsonPath("$.statusOk").value("APROVADO"));
    }

    @Test
    void deveRetornarErro400_QuandoCampoNomeTiverNumero() throws Exception {
        ImoveisDTO dto = new ImoveisDTO();
        dto.setNome("Erro Imóvel111");
        dto.setEndereco("Rua Erro, 999");
        dto.setCep("123456789");
        dto.setTipoDocumentoImoveis(TipoDocumentoImoveis.IPTU);
        dto.setStatusOk(StatusOk.APROVADO);

        String json = new ObjectMapper().writeValueAsString(dto);

        mockMvc.perform(post("/imoveis")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.erros.nome").exists());
    }
}
