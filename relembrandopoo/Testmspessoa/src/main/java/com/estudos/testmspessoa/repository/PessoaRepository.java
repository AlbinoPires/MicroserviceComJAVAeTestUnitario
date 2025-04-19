package com.estudos.testmspessoa.repository;

import com.estudos.testmspessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


    Optional<Pessoa> findByCpf(Double cpf);
}
