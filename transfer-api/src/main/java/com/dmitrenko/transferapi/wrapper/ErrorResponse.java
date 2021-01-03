package com.dmitrenko.transferapi.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
