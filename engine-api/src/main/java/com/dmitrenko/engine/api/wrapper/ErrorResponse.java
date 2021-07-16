package com.dmitrenko.engine.api.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
