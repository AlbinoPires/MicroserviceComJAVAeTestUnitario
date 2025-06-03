package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoImoveis;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class ImoveisDTO {

    private UUID id;

    @NotBlank(message = "Nome é obrigatório.")
    @NotNull
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais")
    private String nome;

    @NotBlank(message = "Endereco é obrigatório.")
    @NotNull
    private String endereco;

    @NotBlank(message = "Endereco é obrigatório.")
    @NotNull
    private String cep;

    @NotNull
    private TipoDocumentoImoveis tipoDocumentoImoveis;

    @NotNull
    private StatusOk statusOk;

    public ImoveisDTO() {}

    public ImoveisDTO(UUID id, String nome, String endereco, String cep,
                      TipoDocumentoImoveis tipoDocumentoImoveis, StatusOk statusOk) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.tipoDocumentoImoveis = tipoDocumentoImoveis;
        this.statusOk = statusOk;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public TipoDocumentoImoveis getTipoDocumentoImoveis() {
        return tipoDocumentoImoveis;
    }

    public void setTipoDocumentoImoveis(TipoDocumentoImoveis tipoDocumentoImoveis) {
        this.tipoDocumentoImoveis = tipoDocumentoImoveis;
    }

    public StatusOk getStatusOk() {
        return statusOk;
    }

    public void setStatusOk(StatusOk statusOk) {
        this.statusOk = statusOk;
    }



}
