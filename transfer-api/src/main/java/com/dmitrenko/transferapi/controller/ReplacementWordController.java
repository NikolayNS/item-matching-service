package com.dmitrenko.transferapi.controller;

import com.dmitrenko.database.dto.request.replacementword.ReplacementWordAddRequest;
import com.dmitrenko.database.dto.request.replacementword.ReplacementWordDeleteRequest;
import com.dmitrenko.database.dto.request.replacementword.ReplacementWordGetRequest;
import com.dmitrenko.database.dto.request.replacementword.ReplacementWordUpdateRequest;
import com.dmitrenko.itemmatchingservice.service.ReplacementWordService;
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
@Api(value = "Remote replacement words management")
public class ReplacementWordController {

	public static final String REPLACEMENT_WORD_ADD = "/api/v1/replacement-word/add";
	public static final String REPLACEMENT_WORD_GET = "/api/v1/replacement-word/get";
	public static final String REPLACEMENT_WORD_GET_ALL = "/api/v1/replacement-word/get-all";
	public static final String REPLACEMENT_WORD_UPDATE = "/api/v1/replacement-word/update";
	public static final String REPLACEMENT_WORD_DELETE = "/api/v1/replacement-word/delete";
	public static final String REPLACEMENT_WORD_DELETE_ALL = "/api/v1/replacement-word/delete-all";

	private final ReplacementWordService service;

	@ApiOperation("Add Replacement word")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = REPLACEMENT_WORD_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ReplacementWordResponse> add(@RequestBody ReplacementWordAddRequest request) {

		return ResponseObject.<ReplacementWordResponse>builder()
			.success(true)
			.message("")
			.data(service.add(request))
			.build();
	}

	@ApiOperation("Get Replacement word")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = REPLACEMENT_WORD_GET, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ReplacementWordResponse> get(@RequestBody ReplacementWordGetRequest request) {

		return ResponseObject.<ReplacementWordResponse>builder()
			.success(true)
			.message("")
			.data(service.get(request))
			.build();
	}

	@ApiOperation("Get all Replacement words")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = REPLACEMENT_WORD_GET_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseList<ReplacementWordResponse> getAll() {

		return ResponseList.<ReplacementWordResponse>builder()
			.success(true)
			.message("")
			.data(service.getAll())
			.build();
	}

	@ApiOperation("Update Replacement word")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = REPLACEMENT_WORD_UPDATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ReplacementWordResponse> update(@RequestBody ReplacementWordUpdateRequest request) {

		return ResponseObject.<ReplacementWordResponse>builder()
			.success(true)
			.message("")
			.data(service.update(request))
			.build();
	}

	@ApiOperation("Delete Replacement word")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = REPLACEMENT_WORD_DELETE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> delete(@RequestBody ReplacementWordDeleteRequest request) {

		service.delete(request);

		return ResponseObject.builder()
			.success(true)
			.message("Replacement word with ID: " + request.getId() + " was deleted")
			.data(null)
			.build();
	}

	@ApiOperation("Delete all Replacement words")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = REPLACEMENT_WORD_DELETE_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> deleteAll() {

		service.deleteAll();

		return ResponseObject.builder()
			.success(true)
			.message("All Replacement words was deleted")
			.data(null)
			.build();
	}
}
