package com.vinicius.ecommerce.resource.exceptions;

import com.sun.net.httpserver.HttpsServer;
import com.vinicius.ecommerce.services.exceptions.DatabaseException;
import com.vinicius.ecommerce.services.exceptions.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ManipulacaoDeExceptions {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoException e,  HttpServletRequest request) {
        String error = "Recurso nao encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao ep =  new ErroPadrao(Instant.now(),status.value() ,error ,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(ep);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErroPadrao> database(DatabaseException e,  HttpServletRequest request) {
        String error = "Erro no banco de dados";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao ep =  new ErroPadrao(Instant.now(),status.value() ,error ,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(ep);
    }

}
