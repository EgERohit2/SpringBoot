package com.api.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(HospitalNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	void handleResourceNotFound(HospitalNotFoundException e) {

		 e.getMessage();
	}
	
	

}
