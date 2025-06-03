package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoParaVeiculos;
import com.cartorio.cartoriotest.domain.model.Veiculos;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class VeiculosDTO {

    private UUID id;

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
    @Size(max = 6, message = "A placa deve ter no máximo 6 caracteres")
    private String placaVeiculo;
    @Enumerated(EnumType.STRING)
    private StatusOk statusOk;

    public VeiculosDTO(UUID id, String nome, TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos, String placaVeiculo, StatusOk statusOk) {
        this.id = id;
        this.nome = nome;
        this.tipoDocumentoParaVeiculos = tipoDocumentoParaVeiculos;
        this.placaVeiculo = placaVeiculo;
        this.statusOk = statusOk;
    }

    public VeiculosDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório") @NotNull @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") @NotNull @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome não pode conter números ou caracteres especiais") String nome) {
        this.nome = nome;
    }

    public TipoDocumentoParaVeiculos getTipoDocumentoParaVeiculos() {
        return tipoDocumentoParaVeiculos;
    }

    public void setTipoDocumentoParaVeiculos(TipoDocumentoParaVeiculos tipoDocumentoParaVeiculos) {
        this.tipoDocumentoParaVeiculos = tipoDocumentoParaVeiculos;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public StatusOk getStatusOk() {
        return statusOk;
    }

    public void setStatusOk(StatusOk statusOk) {
        this.statusOk = statusOk;
    }
}
