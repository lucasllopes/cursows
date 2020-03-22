package com.lucas.cursows.controllers.exceptions;

import java.time.Instant;

import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucas.cursows.services.exceptions.DataBaseException;
import com.lucas.cursows.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Intercepta exceptions para que essa classe execute um possível tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) // esse metodo vai interceptar qualquer exception do tipo ResourceNotFoundException
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request){
		String erro = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError er = new StandardError(Instant.now(),status.value(),ex.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(er);
		
	}
	
	@ExceptionHandler(DataBaseException.class) // esse metodo vai interceptar qualquer exception do tipo DataBaseException
	public ResponseEntity<StandardError> dataBaseException(DataBaseException ex, HttpServletRequest request){
		String erro = "Data Integrity Violation";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError er = new StandardError(Instant.now(),status.value(),ex.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(er);
		
	}

}
