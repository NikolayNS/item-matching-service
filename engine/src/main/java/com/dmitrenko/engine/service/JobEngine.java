package com.dmitrenko.engine.service;

import com.dmitrenko.database.dto.request.task.TaskAddRequest;
import com.dmitrenko.database.dto.request.task.TaskRequest;

public interface JobEngine {

	String add(TaskAddRequest request);

	TaskProgressResponse progress(TaskRequest request);

	ResultResponse get(TaskRequest request);

	boolean cancel(TaskRequest request);
}
