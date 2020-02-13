package com.inno.exception;

import org.springframework.stereotype.Component;

@Component
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public RecordNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
