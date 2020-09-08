package com.dmitrenko.itemmatchingservice.controller;

import com.dmitrenko.itemmatchingservice.dto.request.ItemMatchingRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ItemMatchingResponse;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseObject;
import com.dmitrenko.itemmatchingservice.engine.ItemMatchingEngine;
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

	private final ItemMatchingEngine engine;

	public static final String FIND_MATCHING_ITEMS = "/api/v1/engine/find-matching-items";

	@ApiOperation("Создание нового каталога проектов")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = FIND_MATCHING_ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ItemMatchingResponse> findMatchingItems(@RequestBody ItemMatchingRequest request) {

		return ResponseObject.<ItemMatchingResponse>builder()
			.success(true)
			.message("")
			.data(engine.findMatchingItems(request))
			.build();
	}
}
