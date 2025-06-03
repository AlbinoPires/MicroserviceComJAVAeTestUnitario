package com.cartorio.cartoriotest.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@MappedSuperclass
@Data
public abstract class DocumentoModeloVeiculos {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos;
    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public DocumentoModeloVeiculos(UUID id, String nome, TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos, StatusOk statusOk) {
        this.id = id;
        this.nome = nome;
        this.tipoDocumentoParaVeiculos = tipoDocumentoParaVeiculos;
        this.statusOk = statusOk;

    }



    public DocumentoModeloVeiculos() {}

    public void exibirStatusPBU(){
        System.out.println("-Status: "+ statusOk);
    }

    public void exibirDocumentosVeiculosEImoveis(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\n Documento ID: " + id
                + "\n Tipo documento: " + tipoDocumentoParaVeiculos
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

    public void setNome(@NotBlank @NotNull String nome) {
        this.nome = nome;
    }

    public TipoDocumentoParaVeiculos getTipoDocumentoParaVeiculos() {
        return tipoDocumentoParaVeiculos;
    }

    public void setTipoDocumentoParaVeiculos( TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos) {
        this.tipoDocumentoParaVeiculos = tipoDocumentoParaVeiculos;
    }

    public StatusOk getStatusOk() {
        return statusOk;
    }

    public void setStatusOk(StatusOk statusOk) {
        this.statusOk = statusOk;
    }
}
