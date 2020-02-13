package com.inno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
@ControllerAdvice(value = "com.*")
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public  @ResponseBody String handleUserNotFoundException(Exception ex, WebRequest request) {
	//	RecordNotFoundException errorDetails = new RecordNotFoundException(ex.getMessage());
	//	return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		return "Something went wrong, try after some time..!!";
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleAllException() {
		return "Something went wrong, try after some time..!!";
	}
}
