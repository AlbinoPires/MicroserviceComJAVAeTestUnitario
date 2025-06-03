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

class VeiculosTest {

    private Veiculos veiculos;

    private Validator validator;

    @BeforeEach
    void prepararVeiculosParaTeste(){

        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        this.veiculos = new Veiculos(id, TipoDocumentoParaVeiculos.RENAVAM, StatusOk.APROVADO, "Albino TestUnit", "ABC-123");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveLancarErrosSeNomeContemNumeros(){
        Veiculos veiculos = new Veiculos (UUID.randomUUID(), TipoDocumentoParaVeiculos.RENAVAM,
                StatusOk.APROVADO, "DelRibeiro007", "Placa-123");

        Set<ConstraintViolation<Veiculos>> violacoes = validator.validate(veiculos);

        assertFalse(violacoes.isEmpty());
        assertTrue(violacoes.stream()
                .anyMatch(v -> v.getMessage().contains("Nome não pode conter números")));
    }


    @Test
    void deveRegistrarVeiculosComSucesso(){

        assertNotNull(veiculos.getId());
        assertEquals("Albino TestUnit", veiculos.getNome());
        assertEquals(TipoDocumentoParaVeiculos.RENAVAM, veiculos.getTipoDocumentoParaVeiculos());
        assertEquals(StatusOk.APROVADO, veiculos.getStatusOk());
    }

    @Test
    void deveGerarToStringComTodosOsDados() {
        String texto = veiculos.toString();
        assertTrue(texto.contains("Albino"));
        assertTrue(texto.contains("ABC"));
    }


    @Test
    void devePermitrCriaVeiculoComConstrutorPadrao(){
        Veiculos v = new Veiculos();
        assertNotNull(v);

    }

    @Test
    void deveEditarNome(){
        Veiculos v = new Veiculos();
        v.setNome("Albino TestUnit");
    }

    @Test
    void deveEditarTipoDocumento(){
        Veiculos v = new Veiculos();
        v.setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos.RENAVAM);
    }

    @Test
    void deveEditarStatus(){
        Veiculos v = new Veiculos();
        v.setStatusOk(StatusOk.APROVADO);
    }

    @Test
    void deveEditarPlacaVeiculo(){
        Veiculos v = new Veiculos();
        v.setPlacaVeiculo("Placa-123");
    }

    @Test
    void deveVerificarPlacaVeiculo(){
        veiculos.getPlacaVeiculo();
    }



}