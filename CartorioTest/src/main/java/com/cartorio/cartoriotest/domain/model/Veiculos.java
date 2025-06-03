package com.cartorio.cartoriotest.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

@Entity
@Table(name = "veiculo")
public class Veiculos extends DocumentoModeloVeiculos {

    @NotBlank(message = "Nome é obrigatório")
    @NotNull
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais")
    @Column(length = 50)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos;


    @NotBlank(message = "Registrar uma placa é obrigatório.")
    @NotNull
    @Column(length = 6)
    private String placaVeiculo;

    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public Veiculos(UUID id, TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos, StatusOk status, String nome,
                    String placaVeiculo) {
        super(id, nome, tipoDocumentoParaVeiculos, status);

        this.nome = nome;
        this.placaVeiculo = placaVeiculo;
        this.tipoDocumentoParaVeiculos = tipoDocumentoParaVeiculos;
        this.statusOk = status;

    }

    public Veiculos() {
        super();
    }

    @Override
    public @NotBlank @NotNull String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public TipoDocumentoParaVeiculos getTipoDocumentoParaVeiculos() {
        return tipoDocumentoParaVeiculos;
    }

    @Override
    public void setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos) {
        this.tipoDocumentoParaVeiculos = tipoDocumentoParaVeiculos;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
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
        return  "\n Documento ID: " + getId()
                + "\n Tipo documento: " + tipoDocumentoParaVeiculos
                + "\n Nome: " + nome
                + "\n Status: " + statusOk
                + "\n Placa Veiculo: " + placaVeiculo ;
    }

}