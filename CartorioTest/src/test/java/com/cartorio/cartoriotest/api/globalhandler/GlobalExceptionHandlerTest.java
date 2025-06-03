package com.cartorio.cartoriotest.api.globalhandler;

import com.cartorio.cartoriotest.domain.exception.globalhandler.GlobalExceptionHandler;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void deveTratarMethodArgumentNotValidException() {
        // Mocks necessários
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError erroMock = new FieldError("obj", "campoTeste", "mensagem de erro");

        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        when(ex.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(List.of(erroMock));

        ResponseEntity<Object> resposta = handler.handleValidationErrors(ex);

        assertEquals(400, resposta.getStatusCodeValue());
        assertTrue(resposta.getBody().toString().contains("campoTeste"));
    }

    @Test
    void deveTratarConstraintViolationException() {
        ConstraintViolation<?> violacaoMock = mock(ConstraintViolation.class);
        when(violacaoMock.getMessage()).thenReturn("violação");

        ConstraintViolationException ex = new ConstraintViolationException("erro", Set.of(violacaoMock));

        ResponseEntity<Object> resposta = handler.handleConstraintViolation(ex);

        assertEquals(400, resposta.getStatusCodeValue());
        assertTrue(resposta.getBody().toString().contains("erro"));
    }
}
