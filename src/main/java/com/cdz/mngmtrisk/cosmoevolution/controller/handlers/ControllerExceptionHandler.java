package com.cdz.mngmtrisk.cosmoevolution.controller.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cdz.mngmtrisk.cosmoevolution.dto.MessageError.CustomError;
import com.cdz.mngmtrisk.cosmoevolution.services.exceptions.DatabaseException;
import com.cdz.mngmtrisk.cosmoevolution.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Toda vez que minha exceção lançar um erro deste tipo ->
     * ResourceNotFoundException, DatabaseException,
     * MethodArgumentNotValidException, ...'
     * ele intercepta e retorna isto daqui
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        CustomError err = new CustomError(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
