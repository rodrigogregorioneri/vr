package com.neri.vr.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Credito não encontrado!")
public class CreditNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CreditNotFoundException() {
		super();
	}

	public CreditNotFoundException(String message) {
		super(message);
	}
	
}
