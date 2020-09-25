package com.dmitrenko.itemmatchingservice.engine;

import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;
import com.dmitrenko.itemmatchingservice.dto.response.TaskProgressResponse;

public interface Engine {

	Long add(TaskAddRequest request);

	void run();

	TaskProgressResponse progress(TaskRequest request);

	ResultResponse get(TaskRequest request);

	boolean cancel(TaskRequest request);
}
