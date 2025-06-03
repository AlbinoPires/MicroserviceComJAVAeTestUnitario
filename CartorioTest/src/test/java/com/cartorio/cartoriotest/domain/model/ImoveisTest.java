package com.cartorio.cartoriotest.domain.model;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.Validator;


import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class ImoveisTest {




    private Imoveis imoveis;
    private Validator validator;


    @BeforeEach
    void devePrepararImoveisDTOParaTeste() {

        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        this.imoveis = new Imoveis(id, "Teste Unit A", "Rua A, Bancarios, Rio de Janeiro-RJ", "123456789",
                TipoDocumentoImoveis.IPTU, StatusOk.APROVADO);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();


    }

    @Test
    void deveLancarErroNomeContemNumeros() {


        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        this.imoveis = new Imoveis(id, "Teste Unit A1", "Rua A, Bancarios, Rio de Janeiro-RJ", "123456789",
                TipoDocumentoImoveis.IPTU, StatusOk.APROVADO);

        Set<ConstraintViolation<Imoveis>> violacoes = validator.validate(this.imoveis);

        assertFalse(violacoes.isEmpty());
        assertTrue(violacoes.stream()
                .anyMatch(v -> v.getMessage().contains("Nome não pode conter números")));

    }

    @Test
    void deveRegistrarImovelComSucesso() {
        assertNotNull(imoveis.getId());
        assertEquals("Teste Unit A", imoveis.getNome());
        assertEquals(TipoDocumentoImoveis.IPTU, imoveis.getTipoDocumentoImoveis());
        assertEquals(StatusOk.APROVADO, imoveis.getStatusOk());
    }

    @Test
    void deveGerarToStringComTodososDados(){}

    @Test
    void deveEditarNome(){
        Imoveis imoveis = new Imoveis();
        imoveis.setNome("Teste Unit B");
    }

    @Test
    void deveEditarTipoDocumento(){
        Imoveis imoveis = new Imoveis();
        imoveis.setTipoDocumentoImoveis(TipoDocumentoImoveis.IPTU);
    }

    @Test
    void deveEditarStatus(){
        Imoveis imoveis = new Imoveis();
        imoveis.setStatusOk(StatusOk.APROVADO);
    }

    @Test
    void deveEditarEndereco(){
        Imoveis imoveis = new Imoveis();
        imoveis.setEndereco("Rua B, Bancarios, Rio de Janeiro-RJ");
    }

    @Test
    void Cep(){
        Imoveis imoveis = new Imoveis();
        imoveis.setCep("123456789");
    }

    @Test
    void deveBuscarCep(){
        Imoveis imoveis = new Imoveis();
        imoveis.getCep();

    }
    @Test
    void deveBuscarEndereco(){
        Imoveis imoveis = new Imoveis();
        imoveis.getEndereco();
    }

    @Test
    void deveBuscarStatus(){
        Imoveis imoveis = new Imoveis();
        imoveis.getStatusOk();
    }

    @Test
    void deveTestarToString(){
        String texto = imoveis.toString();
        assertTrue(texto.contains("Teste Unit A"));
    }





}