package com.cartorio.cartoriotest.api.dto;


import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

public class PessoasDTO {

    private UUID id;
    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais")
    private String nome;


    @Enumerated(EnumType.STRING)
    private TipoDocumentoPessoa tipoDocumentoPessoa;
    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public PessoasDTO() {

    }

    public PessoasDTO(UUID id, String nome, TipoDocumentoPessoa tipoDocumentoPessoa, StatusOk statusOk) {
        this.id = id;
        this.nome = nome;
        this.tipoDocumentoPessoa = tipoDocumentoPessoa;
        this.statusOk = statusOk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDocumentoPessoa getTipoDocumentoPessoa() {
        return tipoDocumentoPessoa;
    }

    public void setTipoDocumentoPessoa(TipoDocumentoPessoa tipoDocumentoPessoa) {
        this.tipoDocumentoPessoa = tipoDocumentoPessoa;
    }

    public StatusOk getStatusOk() {
        return statusOk;
    }

    public void setStatusOk(StatusOk statusOk) {
        this.statusOk = statusOk;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
