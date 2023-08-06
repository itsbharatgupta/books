package com.example.book.web.rest.errors;

public class BookBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1743607686027209343L;
	private final ErrorVM error;
	
	public BookBadRequestException(ErrorVM error) {
		this.error = error;
	}

	public ErrorVM getError() {
		return error;
	}

}
