package com.estudos.testmspessoa.dto;

import java.time.LocalDateTime;

public class ErroDTO {

    private String mensagemErro;
    private int status;
    private LocalDateTime timestamp;

    public ErroDTO(String mensagemErro, int status, LocalDateTime timestamp) {
        this.mensagemErro = mensagemErro;
        this.status = status;
        this.timestamp = timestamp;
    }

    public ErroDTO(String mensagemErro, int status) {
        this.mensagemErro = mensagemErro;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
