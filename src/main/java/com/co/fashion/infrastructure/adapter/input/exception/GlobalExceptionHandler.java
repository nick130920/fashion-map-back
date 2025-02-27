package com.co.fashion.infrastructure.adapter.input.exception;

import com.co.fashion.application.exception.ImageUploadException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ImageUploadException.class)
	public ResponseEntity<Map<String, String>> handleImageUploadException(ImageUploadException exception){
		Map<String, String> errorResponse = Map.of("error", exception.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
	}
}
