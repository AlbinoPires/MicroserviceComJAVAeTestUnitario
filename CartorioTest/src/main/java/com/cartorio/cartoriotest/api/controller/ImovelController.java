package com.cartorio.cartoriotest.api.controller;

import com.cartorio.cartoriotest.api.dto.ImoveisDTO;
import com.cartorio.cartoriotest.api.dto.ImovelMapper;
import com.cartorio.cartoriotest.domain.model.Imoveis;
import com.cartorio.cartoriotest.infrastructure.repository.CartorioRepositoryModelImoveis;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelMapper imovelMapper;
    private final CartorioRepositoryModelImoveis cartorioRepositoryModelImoveis;

    public ImovelController(CartorioRepositoryModelImoveis cartorioRepositoryModelImoveis,
                            ImovelMapper imovelMapper) {
        this.cartorioRepositoryModelImoveis = cartorioRepositoryModelImoveis;
        this.imovelMapper = imovelMapper;
    }

    @GetMapping
    public List<ImoveisDTO> listar() {
        return cartorioRepositoryModelImoveis.findAll()
                .stream()
                .map(imovelMapper::toDTO)
                .toList();
    }

    @PostMapping
    public ResponseEntity<ImoveisDTO> salvar(@Valid @RequestBody ImoveisDTO imovelDTO) {
        Imoveis imovelEntity = imovelMapper.toEntity(imovelDTO);
        Imoveis imovelSalvo = cartorioRepositoryModelImoveis.save(imovelEntity);
        ImoveisDTO resposta = imovelMapper.toDTO(imovelSalvo);
        System.out.println("-Enviado: " + imovelSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/simular-cadastro")
    public ResponseEntity<String> simular(@RequestBody ImoveisDTO dto) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(dto);
        producerTemplate.sendBody("direct:cadastro-imovel", json);
        return ResponseEntity.ok("✅ Cadastro orquestrado com sucesso!");
    }

}
