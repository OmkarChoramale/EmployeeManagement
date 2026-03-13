package com.example.exception;

import java.time.LocalDate;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception=EmployeeNotFoundEcxeption.class )
	public ResponseEntity<ExceptionResponse> employeeNotFound(EmployeeNotFoundEcxeption ex){
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(),LocalDate.now(),404);
		return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> validationException(MethodArgumentNotValidException ex) {
	    // Extract all error messages from the exception object
	    String errors = ex.getBindingResult()
	                      .getFieldErrors()
	                      .stream()
	                      .map(err -> err.getField() + ": " + err.getDefaultMessage())
	                      .collect(java.util.stream.Collectors.joining(", "));

	    ExceptionResponse response = new ExceptionResponse(errors, java.time.LocalDate.now(), 400);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGenericException(Exception ex){
        ExceptionResponse exception = new ExceptionResponse("An internal error occurred", LocalDate.now(), 500);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	

		
}

		
