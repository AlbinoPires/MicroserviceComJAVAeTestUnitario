package com.cartorio.cartoriotest.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

@Entity
@Table(name = "pessoa")
public class Pessoas extends DocumentoModeloPessoas {

    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais")
    @Column(length = 50)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoDocumentoPessoa tipoDocumentoPessoa;

    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public Pessoas(UUID id, TipoDocumentoPessoa tipoDocumentoPessoa, StatusOk statusOk, String nome) {
        super(id, tipoDocumentoPessoa, null, statusOk, nome);

        this.nome = nome;
        this.tipoDocumentoPessoa = tipoDocumentoPessoa;
        this.statusOk = statusOk;
    }

    public Pessoas() {
        super();
    }



    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setTipoDocumentoPessoa(TipoDocumentoPessoa tipoDocumentoPessoa) {
        this.tipoDocumentoPessoa = tipoDocumentoPessoa;
    }

    public StatusOk getStatusOk() {
        return statusOk;
    }


    public TipoDocumentoPessoa getTipoDocumentoPessoa() {
        return tipoDocumentoPessoa;
    }

    public void setStatusOk(StatusOk statusOk) {
        this.statusOk = statusOk;
    }

    @Override
    public String toString() {
        return "\n Documento ID: " + getId()
                + "\n Tipo documento: " + tipoDocumentoPessoa
                + "\n Nome: " + nome
                + "\n Status: " + statusOk;
    }

}
