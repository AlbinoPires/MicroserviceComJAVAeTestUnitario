package com.estudos.testmspessoa.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Schema(description = "Objeto de transferência de dados para Pessoa")
public class PessoaDTO {

    private String nome;
    private Double cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @NotNull
    @Size(min = 9, message = "O Cpf deve conter nove caracteres decimais")
    public Double getCpf() {
        return cpf;
    }

    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }


}
