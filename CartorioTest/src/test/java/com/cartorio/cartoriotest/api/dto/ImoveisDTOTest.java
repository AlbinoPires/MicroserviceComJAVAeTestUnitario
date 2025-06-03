package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.Imoveis;
import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoImoveis;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ImoveisDTOTest {

    @Test
    void deveCriarUmImovelComSucesso() {
        ImoveisDTO  imoveisDTO = new ImoveisDTO();
        imoveisDTO.setId(UUID.randomUUID());
        imoveisDTO.setCep("123456789");
        imoveisDTO.setEndereco("Rua A Bancarios, Rio de Janeiro-RJ");
        imoveisDTO.setNome("Teste Unit");
        imoveisDTO.setTipoDocumentoImoveis(TipoDocumentoImoveis.IPTU);
        imoveisDTO.setStatusOk(StatusOk.APROVADO);

        assertEquals("Teste Unit", imoveisDTO.getNome());
        assertEquals("123456789", imoveisDTO.getCep());
        assertEquals("Rua A Bancarios, Rio de Janeiro-RJ", imoveisDTO.getEndereco());
        assertEquals(StatusOk.APROVADO, imoveisDTO.getStatusOk());
        assertEquals(TipoDocumentoImoveis.IPTU, imoveisDTO.getTipoDocumentoImoveis());


    }

    @Test
    void deveCriarConstrutorImoveisDTOComsucesso(){
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        String nome = "Teste Unit";
        String CEP = "123456789";
        String endereco = "Rua A Bancarios, Rio de Janeiro-RJ";
        TipoDocumentoImoveis tipoDocumentoImoveis = TipoDocumentoImoveis.IPTU;
        StatusOk statusOk = StatusOk.APROVADO;

        ImoveisDTO imoveisDTO = new ImoveisDTO(id, nome,  endereco, CEP,  tipoDocumentoImoveis, statusOk);

        assertEquals(id, imoveisDTO.getId());
        assertEquals(nome, imoveisDTO.getNome());
        assertEquals(CEP, imoveisDTO.getCep());
        assertEquals(endereco, imoveisDTO.getEndereco());
        assertEquals(tipoDocumentoImoveis, imoveisDTO.getTipoDocumentoImoveis());

    }









}