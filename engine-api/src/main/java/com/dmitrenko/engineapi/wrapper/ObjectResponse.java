package com.dmitrenko.engineapi.wrapper;

import lombok.Value;

@Value
public class ObjectResponse<T> {
	boolean success;
	T data;

	public static <T> ObjectResponse<T> success(T data) {
		return new ObjectResponse<>(true, data);
	}
}
