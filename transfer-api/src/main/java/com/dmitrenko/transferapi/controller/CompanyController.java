package com.dmitrenko.transferapi.controller;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.transferapi.service.TransferApiService;
import com.dmitrenko.transferapi.wrapper.ListResponse;
import com.dmitrenko.transferapi.wrapper.ObjectResponse;
import com.dmitrenko.transferapi.wrapper.SuccessWrapper;
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
public class CompanyController {

	public static final String COMPANY_ADD = "/api/v1/company";
	public static final String COMPANIES = "/api/v1/companies";
	public static final String COMPANY = "/api/v1/company/{companyId}";
	public static final String COMPANY_TYPE_ADD = "/api/v1/company/type";
	public static final String COMPANY_TYPES = "/api/v1/company/types";
	public static final String COMPANY_TYPE = "/api/v1/company/type/{typeId}";

	private final TransferApiService transferApiService;

	@ResponseStatus(CREATED)
	@PostMapping(value = COMPANY_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add company")
	public ObjectResponse<CompanyResponse> addCompany(@RequestBody CompanyRequest request) {

		return transferApiService.addCompany(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = COMPANY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get company by id")
	public ObjectResponse<CompanyResponse> getCompany(@PathVariable Long companyId) {

		return transferApiService.getCompany(companyId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = COMPANIES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all companies")
	public ListResponse<CompanyResponse> getAllCompanies() {

		return transferApiService.getAllCompanies();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = COMPANY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update company by id")
	public ObjectResponse<CompanyResponse> updateCompany(@PathVariable Long companyId,
														 @RequestBody CompanyRequest request) {

		return transferApiService.updateCompany(companyId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = COMPANY, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete company by id")
	public SuccessWrapper deleteCompany(@PathVariable Long companyId) {

		return transferApiService.deleteCompany(companyId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = COMPANY_TYPE_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add company type")
	public ObjectResponse<CompanyTypeResponse> addCompanyType(@RequestBody CompanyTypeRequest request) {

		return transferApiService.addCompanyType(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = COMPANY_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get company type by id")
	public ObjectResponse<CompanyTypeResponse> getCompanyType(@PathVariable Long typeId) {

		return transferApiService.getCompanyType(typeId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = COMPANY_TYPES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all company types")
	public ListResponse<CompanyTypeResponse> getAllCompanyTypes() {

		return transferApiService.getAllCompanyTypes();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = COMPANY_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update company type by id")
	public ObjectResponse<CompanyTypeResponse> updateCompanyType(@PathVariable Long typeId,
																 @RequestBody CompanyTypeRequest request) {

		return transferApiService.updateCompanyType(typeId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = COMPANY_TYPE, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete company type by id")
	public SuccessWrapper deleteCompanyType(@PathVariable Long typeId) {

		return transferApiService.deleteCompanyType(typeId);
	}
}
