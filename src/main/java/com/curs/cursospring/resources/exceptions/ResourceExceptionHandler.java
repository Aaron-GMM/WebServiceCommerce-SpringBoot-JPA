package com.curs.cursospring.resources.exceptions;

import com.curs.cursospring.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError>  resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error  = "Resrouce not found";
        HttpStatus status =  HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getContextPath() );
      return  ResponseEntity.status(status).body(err);
    }

}
