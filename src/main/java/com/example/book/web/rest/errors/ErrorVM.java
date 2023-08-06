package com.example.book.web.rest.errors;

public class ErrorVM {

	private String message;
	private String details;
	private int errorCode;
	public ErrorVM(String message, String details, int errorCode) {
		super();
		this.message = message;
		this.details = details;
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}	
}
