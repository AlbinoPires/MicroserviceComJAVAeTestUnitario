package com.cartorio.cartoriotest.domain.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
class PessoasTest {

    // Cada anotation gera um teste

    private Pessoas pessoas;
    private Validator validator;

    @BeforeEach
    void prepararPessoasParaTeste() {
        UUID id = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        this.pessoas = new Pessoas(id, TipoDocumentoPessoa.IDENTIDADE_1VIA, StatusOk.APROVADO, "Albino");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    void deveLancarErroSeNomeContemNumeros() {
        Pessoas pessoa = new Pessoas(UUID.randomUUID(), TipoDocumentoPessoa.CPF, StatusOk.APROVADO, "Albino123");

        Set<ConstraintViolation<Pessoas>> violacoes = validator.validate(pessoa);

        assertFalse(violacoes.isEmpty());
        assertTrue(violacoes.stream()
                .anyMatch(v -> v.getMessage().contains("Nome não pode conter números")));
    }

    @Test
    void deveRegistrarPessoasComSucesso() {


        assertNotNull(pessoas.getId());
        assertEquals("Albino", pessoas.getNome());
        assertEquals(TipoDocumentoPessoa.IDENTIDADE_1VIA, pessoas.getTipoDocumentoPessoa());
        assertEquals(StatusOk.APROVADO, pessoas.getStatusOk());
    }

    @Test
    void deveGerarToStringComTodoOsDados(){

        String texto = pessoas.toString();
        assertTrue(texto.contains("Albino"));

    }

    @Test
    void deveEditarNome(){
        Pessoas p = new Pessoas();
        p.setNome("Albino");
    }

    @Test
    void deveEditarTipoDocumento(){
        Pessoas p = new Pessoas();
        p.setTipoDocumentoPessoa(TipoDocumentoPessoa.CPF);
    }

    @Test
    void deveEditarStatusOk(){
        Pessoas p = new Pessoas();
        p.setStatusOk(StatusOk.APROVADO);
    }
}