package com.cartorio.cartoriotest.api.dto;

import com.cartorio.cartoriotest.domain.model.Pessoas;
import com.cartorio.cartoriotest.domain.model.StatusOk;
import com.cartorio.cartoriotest.domain.model.TipoDocumentoPessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PessoaMapperTest {

    @Autowired
    PessoaMapper pessoaMapper;

    @Test
    void deveConverterDTOParaEntidadePessoa() {

        PessoasDTO pessoasDTO = new PessoasDTO(

                UUID.fromString("123e4567-e89b-12d3-a456-426614174000"), "Albino",
                TipoDocumentoPessoa.CPF, StatusOk.APROVADO

        );

        Pessoas pessoa = pessoaMapper.toEntity(pessoasDTO);

        assertEquals(pessoasDTO.getId(), pessoa.getId());
        assertEquals(pessoasDTO.getNome(), pessoa.getNome());
        assertEquals(pessoasDTO.getTipoDocumentoPessoa(), pessoa.getTipoDocumentoPessoa());
        assertEquals(pessoasDTO.getStatusOk(), pessoa.getStatusOk());

    }


}