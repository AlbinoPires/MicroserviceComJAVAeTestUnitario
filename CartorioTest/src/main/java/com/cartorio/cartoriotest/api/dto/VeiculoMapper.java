package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.Veiculos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface VeiculoMapper {

    // DTO <- Entity
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "tipoDocumentoParaVeiculos", source = "tipoDocumentoParaVeiculos")
    @Mapping(target = "placaVeiculo", source = "placaVeiculo")
    @Mapping(target = "statusOk", source = "statusOk")
    VeiculosDTO toDTO(Veiculos veiculos);

    // Entity -> DTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "tipoDocumentoParaVeiculos", source = "tipoDocumentoParaVeiculos")
    @Mapping(target = "placaVeiculo", source = "placaVeiculo")
    @Mapping(target = "statusOk", source = "statusOk")
    Veiculos toEntity(VeiculosDTO veiculosDTO);




}
