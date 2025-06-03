package com.cartorio.cartoriotest.api.dto;


import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoPessoa;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
class PessoasDTOTest {

    @Test
    void deveCriarPessoasDTOComSucesso() {
        PessoasDTO pessoasDTO = new PessoasDTO();
        pessoasDTO.setId(UUID.randomUUID());
        pessoasDTO.setNome("Albino");
        pessoasDTO.setTipoDocumentoPessoa(TipoDocumentoPessoa.CPF);
        pessoasDTO.setStatusOk(StatusOk.APROVADO);


        assertEquals("Albino", pessoasDTO.getNome());
        assertEquals(TipoDocumentoPessoa.CPF, pessoasDTO.getTipoDocumentoPessoa());
        assertEquals(StatusOk.APROVADO, pessoasDTO.getStatusOk());
        assertNotNull(pessoasDTO.getId());

    }


    @Test
    void deveCriarPessoaDTOConstrutorCompleto(){

        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        String nome = "Albino";
        TipoDocumentoPessoa tipoDocumentoPessoa = TipoDocumentoPessoa.CPF;
        StatusOk statusOk = StatusOk.APROVADO;

        PessoasDTO pessoasDTO = new PessoasDTO(id, nome, tipoDocumentoPessoa, statusOk);

        assertEquals(id, pessoasDTO.getId());
        assertEquals(nome, pessoasDTO.getNome());
        assertEquals(tipoDocumentoPessoa, pessoasDTO.getTipoDocumentoPessoa());
        assertEquals(statusOk, pessoasDTO.getStatusOk());

    }




}