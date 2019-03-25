package com.neri.vr.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Credito não encontrado!")
public class EventsNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EventsNotFoundException() {
		super();
	}

	public EventsNotFoundException(String message) {
		super(message);
	}
	
}
