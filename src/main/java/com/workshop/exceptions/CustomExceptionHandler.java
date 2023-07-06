package com.workshop.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workshop.service.exceptions.DatabaseException;
import com.workshop.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice	
public class CustomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		Integer status = HttpStatus.NOT_FOUND.value();
		
		StandartError err = new StandartError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandartError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database exception";
		Integer status = HttpStatus.BAD_REQUEST.value();
		
		StandartError err = new StandartError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
