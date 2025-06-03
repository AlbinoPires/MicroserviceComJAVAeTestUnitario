package com.cartorio.cartoriotest.infrastructure.config;

import com.cartorio.cartoriotest.api.dto.VeiculosDTO;
import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoParaVeiculos;
import com.cartorio.cartoriotest.domain.model.Veiculos;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelVeiculos;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class VeiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartorioRepositoryModelVeiculos repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        Veiculos veiculos = new Veiculos(
                UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                TipoDocumentoParaVeiculos.RENAVAM,
                StatusOk.APROVADO,
                "Veiculo Teste",
                "ABC123"
        );
        repository.save(veiculos);
    }

    @Test
    void deveRetornarListaDeVeiculosComStatus200() throws Exception {
        mockMvc.perform(get("/veiculos") // ou o path correto do seu controller
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Veiculo Teste"))
                .andExpect(jsonPath("$[0].placaVeiculo").value("ABC123"))
                .andExpect(jsonPath("$[0].tipoDocumentoParaVeiculos").value("RENAVAM"))
                .andExpect(jsonPath("$[0].statusOk").value("APROVADO"));
    }

    @Test
    void deveCriarNovoVeiculoERetornarStatus201() throws Exception {

        VeiculosDTO veiculosDTO = new VeiculosDTO();
        veiculosDTO.setNome("Veiculo Teste");
        veiculosDTO.setPlacaVeiculo("ABC123");
        veiculosDTO.setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos.RENAVAM);
        veiculosDTO.setStatusOk(StatusOk.APROVADO);

        String veiculoJson = new ObjectMapper().writeValueAsString(veiculosDTO);

        mockMvc.perform(post("/veiculos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(veiculoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Veiculo Teste"))
                .andExpect(jsonPath("$.placaVeiculo").value("ABC123"))
                .andExpect(jsonPath("$.tipoDocumentoParaVeiculos").value("RENAVAM"))
                .andExpect(jsonPath("$.statusOk").value("APROVADO"));


    }

    // testando o erro 400

    @Test
    void deveRetornarErro400_QuandoCampoPlacaVeiculoForMaiorQuePermitido() throws Exception {

        VeiculosDTO veiculosDTO = new VeiculosDTO();
        veiculosDTO.setNome("Veiculo Teste Caminho Infeliz");
        veiculosDTO.setPlacaVeiculo("ABC1234");
        veiculosDTO.setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos.RENAVAM);
        veiculosDTO.setStatusOk(StatusOk.APROVADO);

        String veiculoJson = new ObjectMapper().writeValueAsString(veiculosDTO);

        mockMvc.perform(post("/veiculos")
        .contentType(MediaType.APPLICATION_JSON)
                .content(veiculoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.erros.placaVeiculo").exists())
                .andExpect(jsonPath("$.erros.placaVeiculo").value("A placa deve ter no máximo 6 caracteres"));
    }



}