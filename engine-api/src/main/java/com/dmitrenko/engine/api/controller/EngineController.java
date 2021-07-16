package com.dmitrenko.engine.api.controller;

import com.dmitrenko.engine.api.service.EngineApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EngineController {

	public static final String TASK_ADD = "/api/v1/engine/task/add";
	public static final String TASK_CHECK = "/api/v1/engine/task/{taskId}";
	public static final String TASK_GET_RESULT = "/api/v1/engine/task/{taskId}/result";
	public static final String TASK_CANCEL = "/api/v1/engine/task/{taskId}/cancel";

	private final EngineApiService engineApiService;


}
