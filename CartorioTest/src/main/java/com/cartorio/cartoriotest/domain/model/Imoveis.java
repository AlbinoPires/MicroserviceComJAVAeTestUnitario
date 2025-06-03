package com.cartorio.cartoriotest.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

@Entity
@Table(name = "imoveis")
public class Imoveis extends DocumentoModeloImoveis {




    @NotNull
    @NotBlank(message = "Nome é obrigatório.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais")
    @Column(length = 50)
    private String nome;

    @NotNull
    @NotBlank(message = "Endereco é obrigatório.")
    @Column(length = 200)
    private String endereco;

    @NotNull
    @NotBlank(message = "Endereco é obrigatório.")
    @Column(length = 9)
    private String cep;

    @Enumerated(EnumType.STRING)
    private TipoDocumentoImoveis tipoDocumentoImoveis;

    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;


    public Imoveis(UUID id, String nome, String endereco, String cep, TipoDocumentoImoveis tipoDocumentoImoveis, StatusOk statusOk ){
        super(id, nome, endereco, cep, tipoDocumentoImoveis, statusOk);

        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.tipoDocumentoImoveis = tipoDocumentoImoveis;
        this.statusOk = statusOk;
    }

    public Imoveis() { super();    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }



    @Override
    public TipoDocumentoImoveis getTipoDocumentoImoveis() {
        return tipoDocumentoImoveis;
    }

    @Override
    public void setTipoDocumentoImoveis(TipoDocumentoImoveis tipoDocumentoImoveis) {
        this.tipoDocumentoImoveis = tipoDocumentoImoveis;
    }

    @Override
    public StatusOk getStatusOk() {
        return statusOk;
    }

    @Override
    public void setStatusOk(StatusOk statusOk) {
        this.statusOk = statusOk;
    }

    @Override
    public String toString() {
        return "\n Documento ID: " + getId()
                + "\n Nome: " + nome
                + "\n Endereco: " + endereco
                + "\n CEP: " + cep
                + "\n Tipo documento: " + tipoDocumentoImoveis
                + "\n Status: " + statusOk;
    }

}
