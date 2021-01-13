package com.dmitrenko.database.service.domain.company;

import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;

import java.util.List;

public interface CompanyTypeDomainService {

	CompanyTypeResponse addCompanyType(CompanyTypeRequest request);

	CompanyTypeResponse getCompanyType(Long typeId);

	List<CompanyTypeResponse> getAllCompanyTypes();

	CompanyTypeResponse updateCompanyType(Long typeId, CompanyTypeRequest request);

	boolean deleteCompanyType(Long typeId);
}
