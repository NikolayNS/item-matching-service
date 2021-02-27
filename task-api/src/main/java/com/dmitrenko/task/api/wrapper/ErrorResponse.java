package com.dmitrenko.task.api.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
