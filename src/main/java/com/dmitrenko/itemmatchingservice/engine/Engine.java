package com.dmitrenko.itemmatchingservice.engine;

import com.dmitrenko.itemmatchingservice.dto.request.engine.ItemsMatchingRequest;
import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;

public interface Engine {

	Long run(ItemsMatchingRequest request);

	boolean progress(TaskRequest request);

	ResultResponse get(TaskRequest request);

	void cancel(TaskRequest request);
}
