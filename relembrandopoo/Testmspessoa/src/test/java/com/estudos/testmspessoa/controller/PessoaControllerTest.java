package com.estudos.testmspessoa.controller;

import com.estudos.testmspessoa.dto.PessoaDTO;
import com.estudos.testmspessoa.exceptions.CpfInvalidoException;
import com.estudos.testmspessoa.exceptions.CpfJaCadastradoException;
import com.estudos.testmspessoa.model.Pessoa;
import com.estudos.testmspessoa.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PessoaControllerTest {

    @Test
    void deveCadastrarPessoaComSucesso() {
        PessoaRepository pessoaRepository = mock(PessoaRepository.class);
        PessoaController controller = new PessoaController(pessoaRepository);

        PessoaDTO dto = new PessoaDTO();
        dto.setNome("Teste");
        dto.setCpf(123456789.0);

        when(pessoaRepository.findByCpf(dto.getCpf())).thenReturn(Optional.empty());

        ResponseEntity<String> resposta = controller.analisarPessoa(dto);

        assertEquals(201, resposta.getStatusCodeValue());
        assertTrue(resposta.getBody().contains("Cadastro concluído com sucesso!"));
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void deveLancarExcecaoParaCpfDuplicado() {
        PessoaRepository pessoaRepository = mock(PessoaRepository.class);
        PessoaController controller = new PessoaController(pessoaRepository);

        PessoaDTO dto = new PessoaDTO();
        dto.setNome("Teste");
        dto.setCpf(123456789.0);

        when(pessoaRepository.findByCpf(dto.getCpf()))
                .thenReturn(Optional.of(new Pessoa()));

        assertThrows(CpfJaCadastradoException.class, () -> controller.analisarPessoa(dto));
        verify(pessoaRepository, never()).save(any());
    }

    @Test
    void deveLancarExcecaoParaCpfInvalido() {
        PessoaRepository pessoaRepository = mock(PessoaRepository.class);
        PessoaController controller = new PessoaController(pessoaRepository);

        PessoaDTO dto = new PessoaDTO();
        dto.setNome("Teste");
        dto.setCpf(123.0); // CPF curto

        assertThrows(CpfInvalidoException.class, () -> controller.analisarPessoa(dto));
        verify(pessoaRepository, never()).save(any());
    }
}
