/*package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.Imoveis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImovelMapper {

    // DTO <- Entity
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "endereco", source = "endereco")
    @Mapping(target = "cep", source = "cep")
    @Mapping(target = "tipoDocumentoImoveis", source = "tipoDocumentoImoveis")
    @Mapping(target = "statusOk", source = "statusOk")
    ImoveisDTO toDTO(Imoveis imovel);

    // Entity <- DTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "endereco", source = "endereco")
    @Mapping(target = "cep", source = "cep")
    @Mapping(target = "tipoDocumentoImoveis", source = "tipoDocumentoImoveis")
    @Mapping(target = "statusOk", source = "statusOk")
    Imoveis toEntity(ImoveisDTO dto);
}
*/
package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.Imoveis;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImovelMapper {

    // Converte entidade para DTO
    ImoveisDTO toDTO(Imoveis imovel);

    // Converte DTO para entidade herdando configuração
    @InheritConfiguration
    Imoveis toEntity(ImoveisDTO dto);
}
