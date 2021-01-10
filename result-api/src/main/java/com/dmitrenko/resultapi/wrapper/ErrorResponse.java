package com.dmitrenko.resultapi.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
