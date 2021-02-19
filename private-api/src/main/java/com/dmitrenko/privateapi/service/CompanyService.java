package com.dmitrenko.privateapi.service;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;

public interface CompanyService {

	ObjectResponse<CompanyResponse> addCompany(CompanyRequest request);

	ObjectResponse<CompanyResponse> getCompany(Long companyId);

	ListResponse<CompanyResponse> getAllCompanies();

	ObjectResponse<CompanyResponse> updateCompany(Long companyId, CompanyRequest request);

	SuccessWrapper deleteCompany(Long companyId);
}
