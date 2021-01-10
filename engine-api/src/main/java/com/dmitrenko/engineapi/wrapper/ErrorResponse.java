package com.dmitrenko.engineapi.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
