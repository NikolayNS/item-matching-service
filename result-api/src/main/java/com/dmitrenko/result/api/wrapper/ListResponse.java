package com.dmitrenko.result.api.wrapper;

import lombok.Value;

import java.util.List;

@Value
public class ListResponse<T> {
	boolean success;
	List<T> data;

	public static <T> ListResponse<T> success(List<T> data) {
		return new ListResponse<>(true, data);
	}
}
