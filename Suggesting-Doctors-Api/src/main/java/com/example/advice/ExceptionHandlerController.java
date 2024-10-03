package com.example.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception.patientNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		
		//System.out.println("method argument not vaid exception please check again ");
		BindingResult br=ex.getBindingResult();
		List<ObjectError> objectErrorList=br.getAllErrors();
		List<String> errorMessageList=new ArrayList<>();
		for(ObjectError error:objectErrorList)
		{
			errorMessageList.add(error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageList);
	}

	
	
	@ExceptionHandler(patientNotFoundException.class)
	public ResponseEntity<Object> PatientNotFoundException(patientNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> RuntimeException(RuntimeException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

		
	}
}
