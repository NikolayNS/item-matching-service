package com.dmitrenko.result.api.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
