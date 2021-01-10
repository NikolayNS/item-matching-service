package com.dmitrenko.database.service.impl;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.database.service.CompanyService;
import com.dmitrenko.database.service.domain.company.CompanyDomainService;
import com.dmitrenko.database.service.domain.company.CompanyTypeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyDomainService companyDomainService;
	private final CompanyTypeDomainService companyTypeDomainService;

	@Override
	public CompanyResponse addCompany(CompanyRequest request) {
		return companyDomainService.addCompany(request);
	}

	@Override
	public CompanyResponse getCompany(Long companyId) {
		return companyDomainService.getCompany(companyId);
	}

	@Override
	public List<CompanyResponse> getAllCompanies() {
		return companyDomainService.getAllCompanies();
	}

	@Override
	public CompanyResponse updateCompany(Long companyId, CompanyRequest request) {
		return companyDomainService.updateCompany(companyId, request);
	}

	@Override
	public void deleteCompany(Long companyId) {
		companyDomainService.deleteCompany(companyId);
	}

	@Override
	public CompanyTypeResponse addCompanyType(CompanyTypeRequest request) {
		return companyTypeDomainService.addCompanyType(request);
	}

	@Override
	public CompanyTypeResponse getCompanyType(Long typeId) {
		return companyTypeDomainService.getCompanyType(typeId);
	}

	@Override
	public List<CompanyTypeResponse> getAllCompanyTypes() {
		return companyTypeDomainService.getAllCompanyTypes();
	}

	@Override
	public CompanyTypeResponse updateCompanyType(Long typeId, CompanyTypeRequest request) {
		return companyTypeDomainService.updateCompanyType(typeId, request);
	}

	@Override
	public void deleteCompanyType(Long companyId) {
		companyTypeDomainService.deleteCompanyType(companyId);
	}
}
