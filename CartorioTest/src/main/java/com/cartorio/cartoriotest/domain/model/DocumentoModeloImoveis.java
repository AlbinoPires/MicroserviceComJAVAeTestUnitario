package com.cartorio.cartoriotest.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@MappedSuperclass
public abstract class DocumentoModeloImoveis {


    @Id
    @GeneratedValue
    private UUID id;


    private String nome;

    private String endereco;


    private String cep;

    @Enumerated(EnumType.STRING)
    private TipoDocumentoImoveis tipoDocumentoImoveis;

    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public DocumentoModeloImoveis(UUID id, String nome, String endereco, String cep,TipoDocumentoImoveis tipoDocumentoImoveis, StatusOk status) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.endereco = endereco;
        this.tipoDocumentoImoveis = tipoDocumentoImoveis;
        this.statusOk = status;
    }

    public DocumentoModeloImoveis() {

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

    @Override
    public String toString() {
        return "\n Documento ID: " + id
                + "\n Nome: " + nome
                + "\n Endereco: " + endereco
                + "\n CEP: " + cep
                + "\n Tipo documento: " + tipoDocumentoImoveis
                + "\n Status: " + statusOk;
    }


}
