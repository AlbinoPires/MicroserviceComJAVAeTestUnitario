package com.cartorio.cartoriotest.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

@MappedSuperclass
public abstract class DocumentoModeloPessoas {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoDocumentoPessoa tipoDocumentoPessoa;

    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public DocumentoModeloPessoas(UUID id, TipoDocumentoPessoa tipoDocumento, TipoDocumentoParaVeiculos tipoDocumentoVeiculosEImoveis, StatusOk status, String nome) {

        this.id = id;
        this.tipoDocumentoPessoa = tipoDocumento;
        this.statusOk = status;
        this.nome = nome;

    }

    public DocumentoModeloPessoas() {
    }

    public void exibirStatus() {
        System.out.println("-Status: " + statusOk);;
    }

    public void exibirTipoDocumento() {
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "\n Documento ID: " + id
                + "\n Tipo documento: " + tipoDocumentoPessoa
                + "\n Nome: " + nome
                + "\n Status: " + statusOk;
    }

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

    public TipoDocumentoPessoa getTipoDocumentoPessoa() {
        return tipoDocumentoPessoa;
    }

    public void setTipoDocumentoPessoa(TipoDocumentoPessoa tipoDocumentoPessoa) {
        this.tipoDocumentoPessoa = tipoDocumentoPessoa;
    }

    public StatusOk getStatusOk() {
        return statusOk;
    }

    public void setStatusOk(StatusOk status) {
        this.statusOk = status;
    }
}
