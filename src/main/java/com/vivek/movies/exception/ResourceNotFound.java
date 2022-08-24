package com.vivek.movies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{
	private static final long serialVersionUID=1L;

	public ResourceNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
