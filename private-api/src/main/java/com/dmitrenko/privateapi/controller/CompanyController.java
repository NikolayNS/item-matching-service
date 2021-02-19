package com.dmitrenko.privateapi.controller;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.privateapi.service.CompanyService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
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

	private final CompanyService companyService;

	@ResponseStatus(CREATED)
	@PostMapping(value = COMPANY_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add company")
	public ObjectResponse<CompanyResponse> addCompany(@RequestBody CompanyRequest request) {

		return companyService.addCompany(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = COMPANY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get company by id")
	public ObjectResponse<CompanyResponse> getCompany(@PathVariable Long companyId) {

		return companyService.getCompany(companyId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = COMPANIES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all companies")
	public ListResponse<CompanyResponse> getAllCompanies() {

		return companyService.getAllCompanies();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = COMPANY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update company by id")
	public ObjectResponse<CompanyResponse> updateCompany(@PathVariable Long companyId,
														 @RequestBody CompanyRequest request) {

		return companyService.updateCompany(companyId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = COMPANY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete company by id")
	public SuccessWrapper deleteCompany(@PathVariable Long companyId) {

		return companyService.deleteCompany(companyId);
	}
}
