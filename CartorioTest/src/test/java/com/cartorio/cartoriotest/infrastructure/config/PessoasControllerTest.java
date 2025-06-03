package com.cartorio.cartoriotest.infrastructure.config;
import com.cartorio.cartoriotest.api.dto.PessoasDTO;
import com.cartorio.cartoriotest.domain.model.*;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelPessoas;

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
class PessoasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CartorioRepositoryModelPessoas repositoryPessoas;

    @BeforeEach
    void criasObjetoPessoa() {

        repositoryPessoas.deleteAll();

        Pessoas pessoa = new Pessoas(
                UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
                TipoDocumentoPessoa.CPF,
                StatusOk.APROVADO,
                "Teste MockValido"
        );

        repositoryPessoas.save(pessoa);
    }

    @Test
    void deveRetornarListaPessoasStatus200() throws Exception {

        mockMvc.perform(get("/pessoas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Teste MockValido"))
                .andExpect(jsonPath("$[0].tipoDocumentoPessoa").value("CPF"))
                .andExpect(jsonPath("$[0].statusOk").value("APROVADO"));

    }

    @Test
    void deveRetornarNovaPessoaCriadaStatusCode201() throws Exception {

        PessoasDTO pessoaTeste = new PessoasDTO();
        pessoaTeste.setNome("Teste MockValido");
        pessoaTeste.setTipoDocumentoPessoa(TipoDocumentoPessoa.CPF);
        pessoaTeste.setStatusOk(StatusOk.APROVADO);

        String pessoaJSON = new ObjectMapper().writeValueAsString(pessoaTeste);

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(pessoaJSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Teste MockValido"))
                .andExpect(jsonPath("$.tipoDocumentoPessoa").value("CPF"))
                .andExpect(jsonPath("$.statusOk").value("APROVADO"));


    }










}