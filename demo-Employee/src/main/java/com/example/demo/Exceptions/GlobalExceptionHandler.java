package com.example.demo.Exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>handlingException(MethodArgumentNotValidException ex) {
		LinkedHashMap<String,String> errorMap=new LinkedHashMap<>();
		List<FieldError>list=ex.getFieldErrors();
		for(FieldError temp:list) {
			String fieldName=temp.getField();
			String errorMsg=temp.getDefaultMessage();
			errorMap.put(fieldName,errorMsg);
		}
		//Map<String,String>errorMap ;
		ResponseEntity<Map<String,String>> rEntity=new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		 return rEntity;
	}
	
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<String> handlingException(EmployeeIdNotFoundException ex) {
		
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(EmployeeNameNotFoundException.class)
	public ResponseEntity<String> handlingException(EmployeeNameNotFoundException ex) {
		
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		return rEntity;
	}
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<String> handlingException(NoEmployeeFoundException ex) {
		
		String msg= ex.getMessage();
		ResponseEntity<String> rEntity=new ResponseEntity<>(msg,HttpStatus.NO_CONTENT);
		return rEntity;
	}

}
