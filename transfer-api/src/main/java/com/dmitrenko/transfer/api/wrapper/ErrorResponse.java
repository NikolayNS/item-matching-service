package com.dmitrenko.transfer.api.wrapper;

import lombok.Value;

@Value
public class ErrorResponse {
	String code;
	String message;
}
