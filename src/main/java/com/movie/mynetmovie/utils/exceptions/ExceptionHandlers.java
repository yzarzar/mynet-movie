package com.movie.mynetmovie.utils.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.movie.mynetmovie.utils.io.ApiResponse;

@RestControllerAdvice
public class ExceptionHandlers {
    
    @ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResponse<List<String>> handle(ApiValidationException e) {
		return ApiResponse.validationError(e.getMessages());
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResponse<List<String>> handle(ApiBusinessException e) {
		return ApiResponse.businessError(e.getMessages());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResponse<String> handle(MethodArgumentNotValidException e) {
		return ApiResponse.platformError(e.getMessage());
	}
}
