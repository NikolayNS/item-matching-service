package com.dmitrenko.itemmatchingservice.controller;

import com.dmitrenko.itemmatchingservice.dto.request.engine.ItemsMatchingRequest;
import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseObject;
import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;
import com.dmitrenko.itemmatchingservice.engine.Engine;
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
public class EngineController {

	private final Engine engine;

	public static final String FIND_MATCHING_ITEMS = "/api/v1/engine/find-matching-items";
	public static final String CHECK_PROGRESS = "/api/v1/engine/check-progress";
	public static final String GET_RESULT = "/api/v1/engine/get-result";
	public static final String CANCEL_TASK = "/api/v1/engine/cancel-task";

	@ApiOperation("Find matching items")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = FIND_MATCHING_ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Long> run(@RequestBody ItemsMatchingRequest request) {

		return ResponseObject.<Long>builder()
			.success(true)
			.message("")
			.data(engine.run(request))
			.build();
	}

	@ApiOperation("Check progress")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = CHECK_PROGRESS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Boolean> check(@RequestBody TaskRequest request) {

		return ResponseObject.<Boolean>builder()
			.success(true)
			.message("")
			.data(engine.progress(request))
			.build();
	}

	@ApiOperation("Get result")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = GET_RESULT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ResultResponse> get(@RequestBody TaskRequest request) {

		return ResponseObject.<ResultResponse>builder()
			.success(true)
			.message("")
			.data(engine.get(request))
			.build();
	}

	@ApiOperation("Cancel task")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = CANCEL_TASK, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Boolean> cancel(@RequestBody TaskRequest request) {

		return ResponseObject.<Boolean>builder()
			.success(true)
			.message("Task with id " + request.getTaskId() + " was canceled")
			.data(engine.cancel(request))
			.build();
	}
}
