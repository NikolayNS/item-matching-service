package com.dmitrenko.engineapi.controller;

import com.dmitrenko.database.dto.request.task.TaskAddRequest;
import com.dmitrenko.database.dto.request.task.TaskRequest;
import com.dmitrenko.itemmatchingservice.engine.JobEngine;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Api(value = "Remote control of item matching service")
public class JobEngineController {

	private final JobEngine jobEngine;

	public static final String FIND_MATCHING_ITEMS = "/api/v1/job-engine/add-task";
	public static final String CHECK_PROGRESS = "/api/v1/job-engine/check-progress";
	public static final String GET_RESULT = "/api/v1/job-engine/get-result";
	public static final String CANCEL_TASK = "/api/v1/job-engine/cancel-task";

	@ApiOperation("Add task to queue")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = FIND_MATCHING_ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<String> add(@RequestBody TaskAddRequest request) {

		return ResponseObject.<String>builder()
			.success(true)
			.message("")
			.data(jobEngine.add(request))
			.build();
	}

	@ApiOperation("Check progress")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = CHECK_PROGRESS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<TaskProgressResponse> check(@RequestBody TaskRequest request) {

		return ResponseObject.<TaskProgressResponse>builder()
			.success(true)
			.message("")
			.data(jobEngine.progress(request))
			.build();
	}

	@ApiOperation("Get result")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = GET_RESULT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ResultResponse> get(@RequestBody TaskRequest request) {

		return ResponseObject.<ResultResponse>builder()
			.success(true)
			.message("")
			.data(jobEngine.get(request))
			.build();
	}

	@ApiOperation("Cancel task")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = CANCEL_TASK, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Boolean> cancel(@RequestBody TaskRequest request) {

		return ResponseObject.<Boolean>builder()
			.success(true)
			.message("Task with id " + request.getName() + " was canceled")
			.data(jobEngine.cancel(request))
			.build();
	}
}
