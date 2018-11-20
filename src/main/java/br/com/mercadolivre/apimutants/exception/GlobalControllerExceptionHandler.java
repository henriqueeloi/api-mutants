package br.com.mercadolivre.apimutants.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ExceptionHandler({ IsNotMutantException.class })
    public ApiErrorResponse handleIsNotMutantException(Exception ex) {
		return new ApiErrorResponse(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), ex.getMessage());
    }
}
