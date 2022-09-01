package com.app.exception;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ApiResponse> resouceNotFoundExceptionHandler(ResourceNotFoundException ex)
		{
			String msg=ex.getMessage();
			ApiResponse apiResponse=new ApiResponse(msg,false);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
			
		}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
	{
	Map<String,String> res=new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error)->{
	String fieldName=((FieldError) error).getField();
	String message=error.getDefaultMessage();
	res.put(fieldName, message);
	});
		return new ResponseEntity<Map<String,String>>(res, HttpStatus.BAD_REQUEST);
	}
	}

