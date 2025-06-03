package com.cartorio.cartoriotest.infrastructure.repository;

import com.cartorio.cartoriotest.domain.model.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartorioRepositoryModelVeiculos extends JpaRepository<Veiculos, UUID> {



}
