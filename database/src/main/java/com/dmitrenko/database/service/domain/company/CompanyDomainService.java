package com.dmitrenko.database.service.domain.company;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;

import java.util.List;

public interface CompanyDomainService {

	CompanyResponse addCompany(CompanyRequest request);

	CompanyResponse getCompany(Long companyId);

	List<CompanyResponse> getAllCompanies();

	CompanyResponse updateCompany(Long companyId, CompanyRequest request);

	void deleteCompany(Long companyId);
}
