package com.cartorio.cartoriotest.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoModeloPessoasTest {

    // Classe anônima concreta para testar a classe abstrata
    DocumentoModeloPessoas pessoa;

    @BeforeEach
    void setUp() {
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
        pessoa = new DocumentoModeloPessoas(id,
                TipoDocumentoPessoa.CPF,
                null,
                StatusOk.APROVADO,
                "Albino"
        ) {
            // classe anônima para instanciar
        };
    }

    @Test
    void testToStringDeveConterDadosEsperados() {
        String toString = pessoa.toString();
        assertTrue(toString.contains("123e4567-e89b-12d3-a456-426614174000"));
        assertTrue(toString.contains("Albino"));
        assertTrue(toString.contains("CPF"));
        assertTrue(toString.contains("APROVADO"));
    }

    @Test
    void testExibirStatusDeveImprimirNoConsole() {
        // captura saída do console
        var out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        pessoa.exibirStatus();

        System.setOut(System.out); // restaura

        assertTrue(out.toString().contains("APROVADO"));
    }

    @Test
    void testExibirTipoDocumentoDeveImprimirToString() {
        var out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        pessoa.exibirTipoDocumento();

        System.setOut(System.out);

        String printed = out.toString();
        assertTrue(printed.contains("Albino"));
        assertTrue(printed.contains("CPF"));
    }

    @Test
    void testGetters() {
        assertEquals("Albino", pessoa.getNome());
        assertEquals(TipoDocumentoPessoa.CPF, pessoa.getTipoDocumentoPessoa());
        assertEquals(StatusOk.APROVADO, pessoa.getStatusOk());
    }

    @Test
    void testSetters() {
        pessoa.setNome("Outro Nome");
        assertEquals("Outro Nome", pessoa.getNome());

        pessoa.setTipoDocumentoPessoa(TipoDocumentoPessoa.CERTIDAO_NASCIMENTO);
        assertEquals(TipoDocumentoPessoa.CERTIDAO_NASCIMENTO, pessoa.getTipoDocumentoPessoa());

        pessoa.setStatusOk(StatusOk.EM_PROCESSAMENTO);
        assertEquals(StatusOk.EM_PROCESSAMENTO, pessoa.getStatusOk());
    }
}
