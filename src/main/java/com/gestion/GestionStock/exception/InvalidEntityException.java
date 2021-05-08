package com.gestion.GestionStock.exception;

import java.util.List;

import lombok.Getter;

@SuppressWarnings("serial")
public class InvalidEntityException extends RuntimeException {
	
	@Getter
	private ErrorCodes errorCode;
	@Getter
	private List<String> errors;
	
	public InvalidEntityException(String message) {
		super(message);
	}
	
	public InvalidEntityException(String message,Throwable cause) {
		super();
	}
	
	public InvalidEntityException(String message,Throwable cause,ErrorCodes erroCode) {
		super(message,cause);
		this.errorCode=erroCode;
	}
	
	public InvalidEntityException(String message,ErrorCodes erroCode) {
		super(message);
		this.errorCode=erroCode;
	}
	
	public InvalidEntityException(String message,ErrorCodes erroCode,List<String> errors) {
		super(message);
		this.errorCode=erroCode;
		this.errors=errors;
	}
}
