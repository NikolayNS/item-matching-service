package com.dmitrenko.itemmatchingservice.controller;

import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.BrandResponse;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseList;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseObject;
import com.dmitrenko.itemmatchingservice.service.BrandService;
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
@Api(value = "Remote brand management")
public class BrandController {

	public static final String BRAND_ADD = "/api/v1/brand/add";
	public static final String BRAND_GET = "/api/v1/brand/get";
	public static final String BRAND_GET_ALL = "/api/v1/brand/get-all";
	public static final String BRAND_UPDATE = "/api/v1/brand/update";
	public static final String BRAND_DELETE = "/api/v1/brand/delete";
	public static final String BRAND_DELETE_ALL = "/api/v1/brand/delete-all";

	private final BrandService service;

	@ApiOperation("Add Brand")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<BrandResponse> add(@RequestBody BrandAddRequest request) {

		return ResponseObject.<BrandResponse>builder()
			.success(true)
			.message("")
			.data(service.add(request))
			.build();
	}

	@ApiOperation("Get Brand")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_GET, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<BrandResponse> get(@RequestBody BrandGetRequest request) {

		return ResponseObject.<BrandResponse>builder()
			.success(true)
			.message("")
			.data(service.get(request))
			.build();
	}

	@ApiOperation("Get all Brands")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_GET_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseList<BrandResponse> getAll() {

		return ResponseList.<BrandResponse>builder()
			.success(true)
			.message("")
			.data(service.getAll())
			.build();
	}

	@ApiOperation("Update Brand")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_UPDATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<BrandResponse> update(@RequestBody BrandUpdateRequest request) {

		return ResponseObject.<BrandResponse>builder()
			.success(true)
			.message("")
			.data(service.update(request))
			.build();
	}

	@ApiOperation("Delete Brand")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_DELETE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> delete(@RequestBody BrandDeleteRequest request) {

		service.delete(request);

		return ResponseObject.builder()
			.success(true)
			.message("Brand with ID: " + request.getId() + " was deleted")
			.data(null)
			.build();
	}

	@ApiOperation("Delete all Brands")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_DELETE_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> deleteAll() {

		service.deleteAll();

		return ResponseObject.builder()
			.success(true)
			.message("All Brands was deleted")
			.data(null)
			.build();
	}
}
