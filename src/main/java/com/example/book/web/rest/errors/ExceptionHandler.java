package com.example.book.web.rest.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler(ItemNotFoundException.class)
	protected ResponseEntity<ErrorVM> handleItemNotFoundException(ItemNotFoundException ex, WebRequest request) {
		return new ResponseEntity<ErrorVM>(ex.getError(), HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(BookBadRequestException.class)
	protected ResponseEntity<ErrorVM> handleBookBadRequestException(BookBadRequestException ex, WebRequest request) {
		return new ResponseEntity<ErrorVM>(ex.getError(), HttpStatus.BAD_REQUEST);
	}
}
