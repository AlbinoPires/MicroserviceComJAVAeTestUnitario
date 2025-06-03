package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoParaVeiculos;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class VeiculosDTOTest {

    @Test
    void deveCriarVeiculosDTOComSucesso() {

        VeiculosDTO veiculosDTO = new VeiculosDTO();

        veiculosDTO.setId(UUID.randomUUID());
        veiculosDTO.setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos.DUT);
        veiculosDTO.setStatusOk(StatusOk.APROVADO);
        veiculosDTO.setPlacaVeiculo("ABC123");
        veiculosDTO.setNome("Albino");

        assertEquals("Albino", veiculosDTO.getNome());
        assertEquals("ABC123", veiculosDTO.getPlacaVeiculo());
        assertEquals(StatusOk.APROVADO, veiculosDTO.getStatusOk());
        assertEquals(TipoDocumentoParaVeiculos.DUT, veiculosDTO.getTipoDocumentoParaVeiculos());

    }

    @Test
    void deveCriarConstrutorVeiculosDTOComSucesso() {

        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos = TipoDocumentoParaVeiculos.DUT;
        String nome = "Albino";
        String  placaVeiculo = "ABC123";
        StatusOk statusOk = StatusOk.APROVADO;

        VeiculosDTO veiculosDTO = new VeiculosDTO(id, nome, tipoDocumentoParaVeiculos, placaVeiculo, statusOk   );

        assertEquals(id, veiculosDTO.getId());
        assertEquals(nome, veiculosDTO.getNome());
        assertEquals(tipoDocumentoParaVeiculos, veiculosDTO.getTipoDocumentoParaVeiculos());
        assertEquals(statusOk, veiculosDTO.getStatusOk());
        assertEquals(placaVeiculo, veiculosDTO.getPlacaVeiculo());
    }



}