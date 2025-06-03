package com.cartorio.cartoriotest.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoModeloVeiculosTest {

    private Veiculos veiculos;

    @BeforeEach
    void criarVeiculosComSucessoParaTeste(){

        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos = TipoDocumentoParaVeiculos.DUT;
        StatusOk statusOk = StatusOk.APROVADO;
        String nome = "Albino";
        String placaVeiculo = "ABC123";

        this.veiculos = new Veiculos(id, tipoDocumentoParaVeiculos, statusOk, nome, placaVeiculo);


    }

    @Test
    void exibirStatusPBU() {

        assertEquals(StatusOk.APROVADO, veiculos.getStatusOk());

    }

    @Test
    void exibirDocumentosVeiculosEImoveis() {
        veiculos.exibirDocumentosVeiculosEImoveis();

    }

    @Test
    void testToString() {
        String exibirFormatado = veiculos.toString();
        assertTrue(exibirFormatado.contains("123e4567-e89b-12d3-a456-426614174000"));
        assertTrue(exibirFormatado.contains("Albino"));
        assertTrue(exibirFormatado.contains("ABC123"));
        assertTrue(exibirFormatado.contains(StatusOk.APROVADO.toString()));
        assertTrue(exibirFormatado.contains(TipoDocumentoParaVeiculos.DUT.toString()));

    }

    @Test
    void getId() {
        assertEquals( UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), veiculos.getId());
    }

    @Test
    void setId() {
        UUID novoId = UUID.randomUUID();
        veiculos.setId(novoId);
        assertEquals(novoId, veiculos.getId());
    }


    @Test
    void getNome() {
        assertEquals( "Albino", veiculos.getNome());
    }

    @Test
    void setNome() {
        veiculos.setNome("Novo Nome");
        assertEquals("Novo Nome", veiculos.getNome());
    }

    @Test
    void getTipoDocumentoParaVeiculos() {
        assertEquals(TipoDocumentoParaVeiculos.DUT, veiculos.getTipoDocumentoParaVeiculos());

    }

    @Test
    void setTipoDocumentoParaVeiculos() {
        veiculos.setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos.DUT);

    }

    @Test
    void getStatusOk() {
        assertEquals( StatusOk.APROVADO, veiculos.getStatusOk());
    }

    @Test
    void setStatusOk() {
        veiculos.setStatusOk(StatusOk.APROVADO);
    }
}