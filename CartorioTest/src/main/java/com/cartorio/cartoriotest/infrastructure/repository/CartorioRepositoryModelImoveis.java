package com.cartorio.cartoriotest.infrastructure.repository;

import com.cartorio.cartoriotest.domain.model.Imoveis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartorioRepositoryModelImoveis extends JpaRepository<Imoveis, UUID> {

}
