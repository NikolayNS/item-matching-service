package com.dmitrenko.itemmatchingservice.controller;

import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ProductGroupResponse;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseList;
import com.dmitrenko.itemmatchingservice.dto.response.ResponseObject;
import com.dmitrenko.itemmatchingservice.service.ProductGroupService;
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
@Api(value = "Remote product group management")
public class ProductGroupController {

	public static final String PRODUCT_GROUP_ADD = "/api/v1/product-group/add";
	public static final String PRODUCT_GROUP_GET = "/api/v1/product-group/get";
	public static final String PRODUCT_GROUP_GET_ALL = "/api/v1/product-group/get-all";
	public static final String PRODUCT_GROUP_UPDATE = "/api/v1/product-group/update";
	public static final String PRODUCT_GROUP_DELETE = "/api/v1/product-group/delete";
	public static final String PRODUCT_GROUP_DELETE_ALL = "/api/v1/product-group/delete-all";

	private final ProductGroupService service;

	@ApiOperation("Add Product group")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = PRODUCT_GROUP_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ProductGroupResponse> add(@RequestBody ProductGroupAddRequest request) {

		return ResponseObject.<ProductGroupResponse>builder()
			.success(true)
			.message("")
			.data(service.add(request))
			.build();
	}

	@ApiOperation("Get Product group")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = PRODUCT_GROUP_GET, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ProductGroupResponse> get(@RequestBody ProductGroupGetRequest request) {

		return ResponseObject.<ProductGroupResponse>builder()
			.success(true)
			.message("")
			.data(service.get(request))
			.build();
	}

	@ApiOperation("Get all Product groups")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = PRODUCT_GROUP_GET_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseList<ProductGroupResponse> getAll() {

		return ResponseList.<ProductGroupResponse>builder()
			.success(true)
			.message("")
			.data(service.getAll())
			.build();
	}

	@ApiOperation("Update Product group")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = PRODUCT_GROUP_UPDATE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<ProductGroupResponse> update(@RequestBody ProductGroupUpdateRequest request) {

		return ResponseObject.<ProductGroupResponse>builder()
			.success(true)
			.message("")
			.data(service.update(request))
			.build();
	}

	@ApiOperation("Delete Product group")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = PRODUCT_GROUP_DELETE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> delete(@RequestBody ProductGroupDeleteRequest request) {

		service.delete(request);

		return ResponseObject.builder()
			.success(true)
			.message("Product group with ID: " + request.getId() + " was deleted")
			.data(null)
			.build();
	}

	@ApiOperation("Delete all Product groups")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = PRODUCT_GROUP_DELETE_ALL, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseObject<Object> deleteAll() {

		service.deleteAll();

		return ResponseObject.builder()
			.success(true)
			.message("All Product groups was deleted")
			.data(null)
			.build();
	}
}
