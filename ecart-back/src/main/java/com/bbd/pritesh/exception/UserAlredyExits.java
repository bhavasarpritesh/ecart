package com.bbd.pritesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class UserAlredyExits extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlredyExits() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAlredyExits(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

    
}
