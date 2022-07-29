package com.bbd.pritesh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductCategoryNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductCategoryNotFound() {
		// TODO Auto-generated constructor stub
	}
	public ProductCategoryNotFound(String msg) {
		super(msg);
	}
}
