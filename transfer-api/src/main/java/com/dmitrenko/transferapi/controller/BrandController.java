package com.dmitrenko.transferapi.controller;

import com.dmitrenko.database.dto.request.brand.BrandAddRequest;
import com.dmitrenko.database.dto.request.brand.BrandDeleteRequest;
import com.dmitrenko.database.dto.request.brand.BrandGetRequest;
import com.dmitrenko.database.dto.request.brand.BrandUpdateRequest;
import com.dmitrenko.database.dto.response.item.BrandNameResponse;
import com.dmitrenko.transferapi.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class BrandController {

	public static final String BRAND_ADD = "/api/v1/brand/add";
	public static final String BRAND_GET = "/api/v1/brand/get";
	public static final String BRAND_GET_ALL = "/api/v1/brand/get-all";
	public static final String BRAND_UPDATE = "/api/v1/brand/update";
	public static final String BRAND_DELETE = "/api/v1/brand/delete";
	public static final String BRAND_DELETE_ALL = "/api/v1/brand/delete-all";

	private final TransferService transferService; 

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<BrandNameResponse> add(@RequestBody BrandAddRequest request) {

		return ResponseObject.<BrandNameResponse>builder()
			.success(true)
			.message("")
			.data(service.add(request))
			.build();
	}

	@ApiOperation("Get Brand")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_GET, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<BrandNameResponse> get(@RequestBody BrandGetRequest request) {

		return ResponseObject.<BrandNameResponse>builder()
			.success(true)
			.message("")
			.data(service.get(request))
			.build();
	}

	@ApiOperation("Get all Brands")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_GET_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseList<BrandNameResponse> getAll() {

		return ResponseList.<BrandNameResponse>builder()
			.success(true)
			.message("")
			.data(service.getAll())
			.build();
	}

	@ApiOperation("Update Brand")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = BRAND_UPDATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<BrandNameResponse> update(@RequestBody BrandUpdateRequest request) {

		return ResponseObject.<BrandNameResponse>builder()
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
