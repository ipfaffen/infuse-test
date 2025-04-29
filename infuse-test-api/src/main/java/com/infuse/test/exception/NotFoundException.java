package com.infuse.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {

	public NotFoundException(String message) {
		super(HttpStatus.NOT_FOUND, message);
	}

	public NotFoundException(String message, Object... args) {
		super(HttpStatus.NOT_FOUND, String.format(message, args));
	}
}