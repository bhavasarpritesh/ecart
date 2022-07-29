package com.bbd.pritesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderProductNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     public OrderProductNotFound() {
		// TODO Auto-generated constructor stub
	}
     public OrderProductNotFound(String msg) {
 		super(msg);
 	}  
}
