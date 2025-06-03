package com.cartorio.cartoriotest.api.controller;

import com.cartorio.cartoriotest.api.dto.PessoaMapper;
import com.cartorio.cartoriotest.api.dto.PessoasDTO;
import com.cartorio.cartoriotest.domain.model.*;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelPessoas;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pessoas")
public class PessoasController {


    private final PessoaMapper pessoaMapper;
    private final CartorioRepositoryModelPessoas cartorioRepositoryModelPessoas;

    public PessoasController(CartorioRepositoryModelPessoas cartorioRepositoryModelPessoas,

                             PessoaMapper pessoaMapper) {
        this.cartorioRepositoryModelPessoas = cartorioRepositoryModelPessoas;
        this.pessoaMapper = pessoaMapper;
    }

    @GetMapping
    public List<PessoasDTO> listar(){
        return cartorioRepositoryModelPessoas.findAll()
                .stream()
                .map(pessoaMapper::toDTO)
                .toList();

    }


    @PostMapping
    public ResponseEntity<PessoasDTO> salvar(@Valid @RequestBody PessoasDTO pessoaDTO) {

        Pessoas pessoaEntity = pessoaMapper.toEntity(pessoaDTO);
        Pessoas pessoaSalva = cartorioRepositoryModelPessoas.save(pessoaEntity);
        PessoasDTO resposta = pessoaMapper.toDTO(pessoaSalva);
        System.out.println("-Enviado: " + pessoaSalva.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}




