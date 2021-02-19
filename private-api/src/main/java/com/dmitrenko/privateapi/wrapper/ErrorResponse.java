package com.dmitrenko.privateapi.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
