package com.enterprise.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enterprise.course.services.exceptions.ResourceNotFoundException;

//Este anotation é que vai interceptar para mim as excepoões para as poder tratar aqui por este objeto
@ControllerAdvice
public class ResourceExceptionHandler {
	
	//quero apanhar qualqueer excepção deste tipo e trata la aqui dentro
	@ExceptionHandler(ResourceNotFoundException.class) //nome da excepção a interceptar
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

}
