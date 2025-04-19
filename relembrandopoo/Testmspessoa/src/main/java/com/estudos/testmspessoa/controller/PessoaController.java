package com.estudos.testmspessoa.controller;


import com.estudos.testmspessoa.dto.PessoaDTO;
import com.estudos.testmspessoa.exceptions.CpfInvalidoException;
import com.estudos.testmspessoa.exceptions.CpfJaCadastradoException;
import com.estudos.testmspessoa.model.Pessoa;
import com.estudos.testmspessoa.repository.PessoaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
@Tag(name = "Pessoa Controller", description = "Operações relacionadas a pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }



    @PostMapping
    public ResponseEntity<String> analisarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        String nome = pessoaDTO.getNome();
        Double cpf = pessoaDTO.getCpf();

        String cpfString = String.valueOf(cpf.longValue());

        if (cpfString.length() < 9){
            throw new CpfInvalidoException("CPF invalido MULA, retorne com 9 numeros, caralho!!!");
        }
        Optional<Pessoa> existente = pessoaRepository.findByCpf(cpf);
        if (existente.isPresent()){
            throw new CpfJaCadastradoException(cpfString);
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());

        pessoaRepository.save(pessoa);

        String resposta = String.format("Cadastro concluído com sucesso!\nNome: %s\nCPF: %.0f", nome, cpf);
        System.out.println(resposta);
        System.out.println("Teste realizado com sucesso, dados mostrados no terminal do microsservice!");

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);


    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok(pessoas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        return ResponseEntity.ok(pessoa.get());
    }

}
