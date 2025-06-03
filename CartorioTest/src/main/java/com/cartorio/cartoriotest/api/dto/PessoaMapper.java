package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.Pessoas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {




    // DTO <- Entity
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "tipoDocumentoPessoa", source = "tipoDocumentoPessoa")
    @Mapping(target = "statusOk", source = "statusOk")  // Corrigido!
    PessoasDTO toDTO(Pessoas pessoa);

    // Entity <- DTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "tipoDocumentoPessoa", source = "tipoDocumentoPessoa")
    @Mapping(target = "statusOk", source = "statusOk")  // Corrigido!
    Pessoas toEntity(PessoasDTO dto);
}
