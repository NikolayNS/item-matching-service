package com.dmitrenko.database.service;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;

import java.util.List;

public interface CompanyService {

	CompanyResponse addCompany(CompanyRequest request);

	CompanyResponse getCompany(Long companyId);

	List<CompanyResponse> getAllCompanies();

	CompanyResponse updateCompany(Long companyId, CompanyRequest request);

	boolean deleteCompany(Long companyId);

	CompanyTypeResponse addCompanyType(CompanyTypeRequest request);

	CompanyTypeResponse getCompanyType(Long typeId);

	List<CompanyTypeResponse> getAllCompanyTypes();

	CompanyTypeResponse updateCompanyType(Long typeId, CompanyTypeRequest request);

	boolean deleteCompanyType(Long typeId);
}
