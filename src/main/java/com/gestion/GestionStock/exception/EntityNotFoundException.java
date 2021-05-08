package com.gestion.GestionStock.exception;

import lombok.Getter;

@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException{
	
	@Getter
	private ErrorCodes errorCode;
	
	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message,Throwable cause) {
		super();
	}
	
	public EntityNotFoundException(String message,Throwable cause,ErrorCodes errorCode) {
		super(message,cause);
		this.errorCode=errorCode;
	}
	
	public EntityNotFoundException(String message,ErrorCodes errorCode) {
		super(message);
		this.errorCode=errorCode;
	}

}
