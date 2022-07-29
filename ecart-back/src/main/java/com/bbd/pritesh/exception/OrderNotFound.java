package com.bbd.pritesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFound() {
		// TODO Auto-generated constructor stub
	}

	public OrderNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}



}
