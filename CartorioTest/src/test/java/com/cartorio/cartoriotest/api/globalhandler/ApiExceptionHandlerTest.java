package com.cartorio.cartoriotest.api.globalhandler;

import com.cartorio.cartoriotest.api.dto.VeiculoMapper;
import com.cartorio.cartoriotest.api.dto.VeiculosDTO;
import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoParaVeiculos;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelVeiculos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CartorioRepositoryModelVeiculos cartorioRepositoryModelVeiculos;

    @MockBean
    private VeiculoMapper veiculoMapper;

    @Test
    void deveRetornarErro400_QuandoCampoPlacaVeiculoForMaiorQue6() throws Exception {
        VeiculosDTO veiculoInvalido = new VeiculosDTO(
                UUID.randomUUID(),
                "Veiculo Teste",
                TipoDocumentoParaVeiculos.RENAVAM,
                "ABC1234", // inválido: 7 caracteres
                StatusOk.APROVADO
        );

        mockMvc.perform(post("/veiculos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(veiculoInvalido)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.erro").value("Erro de validação nos campos"))
                .andExpect(jsonPath("$.erros.placaVeiculo").exists());
    }
}
