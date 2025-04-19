package com.estudos.testmspessoa.exceptions;

import com.estudos.testmspessoa.dto.ErroDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.estudos.testmspessoa.exceptions.CpfInvalidoException;
import com.estudos.testmspessoa.exceptions.CpfJaCadastradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<ErroDTO> handleCpfCadastrado(CpfJaCadastradoException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErroDTO(ex.getMessage(), HttpStatus.CONFLICT.value()));
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<ErroDTO> handleCpfInvalido(CpfInvalidoException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErroDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> handleGeral(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErroDTO("Erro interno inesperado, desculpe o transtorno, estamos resolvendo!", 500));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroDTO> handleEntityNotFound(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErroDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }




}
