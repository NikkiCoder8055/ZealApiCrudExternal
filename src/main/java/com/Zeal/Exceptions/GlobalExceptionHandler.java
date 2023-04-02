package com.Zeal.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Zeal.Utils.ApiResponseReturn;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ApiResponseReturn> ResourceNotFound (ResourceNotFound ex){
		String message = ex.getMessage();
		ApiResponseReturn apiResponseReturn = new ApiResponseReturn(message, false);
		return new ResponseEntity<ApiResponseReturn>(apiResponseReturn,HttpStatus.NOT_FOUND);
	}

}
