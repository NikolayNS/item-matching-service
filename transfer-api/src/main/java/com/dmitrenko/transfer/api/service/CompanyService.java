package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface CompanyService {

	ObjectResponse<CompanyResponse> addCompany(CompanyRequest request);

	ObjectResponse<CompanyResponse> getCompany(Long companyId);

	ListResponse<CompanyResponse> getAllCompanies();

	ObjectResponse<CompanyResponse> updateCompany(Long companyId, CompanyRequest request);

	SuccessWrapper deleteCompany(Long companyId);

	ObjectResponse<CompanyTypeResponse> addCompanyType(CompanyTypeRequest request);

	ObjectResponse<CompanyTypeResponse> getCompanyType(Long typeId);

	ListResponse<CompanyTypeResponse> getAllCompanyTypes();

	ObjectResponse<CompanyTypeResponse> updateCompanyType(Long typeId, CompanyTypeRequest request);

	SuccessWrapper deleteCompanyType(Long typeId);
}
