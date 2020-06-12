package com.onlineApp.ExceptionHandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    public GeneralExceptionHandler() {
        System.out.println("ExceptionHandler Called");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,HttpHeaders headers,HttpStatus status,WebRequest request) {
        Map<String, String> responseErrors = new HashMap<>();

        if (exception.getBindingResult().hasGlobalErrors()) {
            System.out.println("Inside Global errors");
            for (ObjectError error : exception.getBindingResult().getGlobalErrors()) {
                responseErrors.put("Global: " + error.getObjectName(), "Message: " + error.getDefaultMessage());
            }
        }
        if (exception.getBindingResult().hasFieldErrors()) {
            System.out.println("Inside Field errors");
            int i = 1;
            for (FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
                responseErrors.put(i++ + ": " + fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        logger.error(exception);
        return new ResponseEntity<>(responseErrors, headers, status);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(ResourceNotFoundException ex, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        ErrorHandler error = new ErrorHandler(ex.getMessage(), servletWebRequest.getRequest().getRequestURL().toString());
        logger.error(error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ResourceAlreadyExistException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(ResourceAlreadyExistException ex, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        ErrorHandler error = new ErrorHandler(ex.getMessage(), servletWebRequest.getRequest().getRequestURL().toString());
        logger.error(error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
