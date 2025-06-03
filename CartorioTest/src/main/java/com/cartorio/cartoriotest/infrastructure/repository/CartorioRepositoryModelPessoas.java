package com.cartorio.cartoriotest.infrastructure.repository;

import com.cartorio.cartoriotest.domain.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CartorioRepositoryModelPessoas extends JpaRepository<Pessoas, UUID> {


}
