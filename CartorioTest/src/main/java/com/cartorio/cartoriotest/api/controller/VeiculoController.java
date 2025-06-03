package com.cartorio.cartoriotest.api.controller;


import com.cartorio.cartoriotest.api.dto.VeiculoMapper;
import com.cartorio.cartoriotest.api.dto.VeiculosDTO;
import com.cartorio.cartoriotest.domain.model.Veiculos;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelVeiculos;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private VeiculoMapper veiculoMapper;

    private CartorioRepositoryModelVeiculos cartorioRepositoryModelVeiculos;

    public VeiculoController(CartorioRepositoryModelVeiculos cartorioRepositoryModelVeiculos,
                             VeiculoMapper veiculoMapper ) {
        this.cartorioRepositoryModelVeiculos = cartorioRepositoryModelVeiculos;
        this.veiculoMapper = veiculoMapper;
    }

    @GetMapping
    public List<VeiculosDTO> listar(){
        return cartorioRepositoryModelVeiculos.findAll()
                .stream()
                .map(veiculoMapper::toDTO)
                .toList();
    }

    @PostMapping
    public ResponseEntity<VeiculosDTO>salvar(@Valid @RequestBody VeiculosDTO veiculoDTO){
        Veiculos veiculoEntity = veiculoMapper.toEntity(veiculoDTO);
        Veiculos veiculoSalvo = cartorioRepositoryModelVeiculos.save(veiculoEntity);
        VeiculosDTO resposta = veiculoMapper.toDTO(veiculoSalvo);
        System.out.println("-Enviado: " + veiculoSalvo.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }



}
