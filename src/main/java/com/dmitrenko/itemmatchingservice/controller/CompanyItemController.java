package com.dmitrenko.itemmatchingservice.controller;

import com.dmitrenko.itemmatchingservice.dto.request.add.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.CompanyItemDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.CompanyItemGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.CompanyItemUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.CompanyItemResponse;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseList;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseObject;
import com.dmitrenko.itemmatchingservice.service.CompanyItemService;
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
@Api(value = "Remote company items management")
public class CompanyItemController {

	public static final String COMPANY_ITEM_ADD = "/api/v1/company-item/add";
	public static final String COMPANY_ITEM_GET = "/api/v1/company-item/get";
	public static final String COMPANY_ITEM_GET_ALL = "/api/v1/company-item/get-all";
	public static final String COMPANY_ITEM_UPDATE = "/api/v1/company-item/update";
	public static final String COMPANY_ITEM_DELETE = "/api/v1/company-item/delete";
	public static final String COMPANY_ITEM_DELETE_ALL = "/api/v1/company-item/delete-all";

	private final CompanyItemService service;

	@ApiOperation("Add Company item")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = COMPANY_ITEM_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<CompanyItemResponse> add(@RequestBody CompanyItemAddRequest request) {

		return ResponseObject.<CompanyItemResponse>builder()
			.success(true)
			.message("")
			.data(service.add(request))
			.build();
	}

	@ApiOperation("Get Company item")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = COMPANY_ITEM_GET, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<CompanyItemResponse> get(@RequestBody CompanyItemGetRequest request) {

		return ResponseObject.<CompanyItemResponse>builder()
			.success(true)
			.message("")
			.data(service.get(request))
			.build();
	}

	@ApiOperation("Get all Company items")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = COMPANY_ITEM_GET_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseList<CompanyItemResponse> getAll() {

		return ResponseList.<CompanyItemResponse>builder()
			.success(true)
			.message("")
			.data(service.getAll())
			.build();
	}

	@ApiOperation("Update Company item")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = COMPANY_ITEM_UPDATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<CompanyItemResponse> update(@RequestBody CompanyItemUpdateRequest request) {

		return ResponseObject.<CompanyItemResponse>builder()
			.success(true)
			.message("")
			.data(service.update(request))
			.build();
	}

	@ApiOperation("Delete Company item")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = COMPANY_ITEM_DELETE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> delete(@RequestBody CompanyItemDeleteRequest request) {

		service.delete(request);

		return ResponseObject.builder()
			.success(true)
			.message("Company item with ID: " + request.getId() + " was deleted")
			.data(null)
			.build();
	}

	@ApiOperation("Delete all Company items")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = COMPANY_ITEM_DELETE_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> deleteAll() {

		service.deleteAll();

		return ResponseObject.builder()
			.success(true)
			.message("All Company items was deleted")
			.data(null)
			.build();
	}
}
