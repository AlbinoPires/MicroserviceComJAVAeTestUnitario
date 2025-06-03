package com.cartorio.cartoriotest.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class DocumentoModeloImoveisTest {

    private Imoveis imoveis;

    @BeforeEach
    void deveCriarImovelComSucessoParaTeste() {

        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        String nome = "Teste Unitario";
        String endereco = "Rua A bancarios Rio de janeiro RJ";
        String cep = "123456789";
        TipoDocumentoImoveis tipoDocumentoImoveis = TipoDocumentoImoveis.IPTU;
        StatusOk statusOk = StatusOk.APROVADO;

        this.imoveis = new Imoveis(id, nome, endereco, cep, tipoDocumentoImoveis, statusOk);

    }



        @Test
        void getId() {

            assertEquals( UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), imoveis.getId());
        }

        @Test
        void setId() {
            UUID novoId = UUID.randomUUID();
            imoveis.setId(novoId);
            assertEquals(novoId, imoveis.getId());
        }


        @Test
        void getNome() {
            assertEquals( "Teste Unitario", imoveis.getNome());
        }

        @Test
        void setNome() {

            imoveis.setNome("Novo Nome");
            assertEquals("Novo Nome", imoveis.getNome());
        }

        @Test
        void getTipoDocumentoParaImoveis() {
            assertEquals(TipoDocumentoImoveis.IPTU, imoveis.getTipoDocumentoImoveis());

        }

        @Test
        void setTipoDocumentoParaVeiculos() {
            imoveis.setTipoDocumentoImoveis(TipoDocumentoImoveis.IPTU);
            assertEquals(TipoDocumentoImoveis.IPTU, imoveis.getTipoDocumentoImoveis());

        }

        @Test
        void getStatusOk() {
            assertEquals( StatusOk.APROVADO, imoveis.getStatusOk());
        }

        @Test
        void setStatusOk() {
            imoveis.setStatusOk(StatusOk.APROVADO);
            assertEquals(StatusOk.APROVADO, imoveis.getStatusOk());
        }


    }


  
