package com.dmitrenko.transferapi.controller;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesAddRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.transferapi.service.TransferApiService;
import com.dmitrenko.transferapi.wrapper.ListResponse;
import com.dmitrenko.transferapi.wrapper.ObjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class BrandNameController {

	public static final String BRAND_NAME_ADD = "/api/v1/brand-name";
	public static final String BRAND_NAMES = "/api/v1/brand-names";
	public static final String BRAND_NAME = "/api/v1/brand-name/{brandNameId}";

	private final TransferApiService transferApiService;

	@ResponseStatus(CREATED)
	@PostMapping(value = BRAND_NAME_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add brand name")
	public ObjectResponse<BrandNameResponse> addBrandName(@RequestBody BrandNameRequest request) {

		return transferApiService.addBrandName(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = BRAND_NAMES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add brand names")
	public ListResponse<BrandNameResponse> addBrandNames(@RequestBody BrandNamesAddRequest request) {

		return transferApiService.addBrandNames(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = BRAND_NAME, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get brand name by id")
	public ObjectResponse<BrandNameResponse> getBrandName(@PathVariable Long brandNameId) {

		return transferApiService.getBrandName(brandNameId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = BRAND_NAMES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all brand names")
	public ListResponse<BrandNameResponse> getAllBrandNames() {

		return transferApiService.getAllBrandNames();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = BRAND_NAME, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update brand name by id")
	public ObjectResponse<BrandNameResponse> updateBrandName(@PathVariable Long brandNameId,
															 @RequestBody BrandNameRequest request) {

		return transferApiService.updateBrandName(brandNameId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = BRAND_NAME, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete brand name by id")
	public void deleteBrandName(@PathVariable Long brandNameId) {

		transferApiService.deleteBrandName(brandNameId);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = BRAND_NAMES, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete all brand name")
	public void deleteAllBrandNames() {

		transferApiService.deleteAllBrandNames();
	}
}
