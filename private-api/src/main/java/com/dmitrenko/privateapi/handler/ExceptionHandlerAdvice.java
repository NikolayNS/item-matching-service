package com.dmitrenko.privateapi.handler;

import com.dmitrenko.database.exception.InvalidRequestException;
import com.dmitrenko.privateapi.wrapper.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler({InvalidRequestException.class})
	@ResponseStatus(BAD_REQUEST)
	public ErrorResponse handleWebDavException(InvalidRequestException e) {
		log.error("Wrong request exception", e);
		return new ErrorResponse("BAD_REQUEST", e.getMessage());
	}
}
