package com.dmitrenko.transfer.api.service.impl;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.database.service.domain.company.CompanyDomainService;
import com.dmitrenko.database.service.domain.company.CompanyTypeDomainService;
import com.dmitrenko.transfer.api.service.CompanyService;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyDomainService companyDomainService;
	private final CompanyTypeDomainService companyTypeDomainService;

	@Override
	public ObjectResponse<CompanyResponse> addCompany(CompanyRequest request) {
		return ObjectResponse.success(companyDomainService.addCompany(request));
	}

	@Override
	public ObjectResponse<CompanyResponse> getCompany(Long companyId) {
		return ObjectResponse.success(companyDomainService.getCompany(companyId));
	}

	@Override
	public ListResponse<CompanyResponse> getAllCompanies() {
		return ListResponse.success(companyDomainService.getAllCompanies());
	}

	@Override
	public ObjectResponse<CompanyResponse> updateCompany(Long companyId, CompanyRequest request) {
		return ObjectResponse.success(companyDomainService.updateCompany(companyId, request));
	}

	@Override
	public SuccessWrapper deleteCompany(Long companyId) {
		return new SuccessWrapper(companyDomainService.deleteCompany(companyId));
	}

	@Override
	public ObjectResponse<CompanyTypeResponse> addCompanyType(CompanyTypeRequest request) {
		return ObjectResponse.success(companyTypeDomainService.addCompanyType(request));
	}

	@Override
	public ObjectResponse<CompanyTypeResponse> getCompanyType(Long typeId) {
		return ObjectResponse.success(companyTypeDomainService.getCompanyType(typeId));
	}

	@Override
	public ListResponse<CompanyTypeResponse> getAllCompanyTypes() {
		return ListResponse.success(companyTypeDomainService.getAllCompanyTypes());
	}

	@Override
	public ObjectResponse<CompanyTypeResponse> updateCompanyType(Long typeId, CompanyTypeRequest request) {
		return ObjectResponse.success(companyTypeDomainService.updateCompanyType(typeId, request));
	}

	@Override
	public SuccessWrapper deleteCompanyType(Long typeId) {
		return new SuccessWrapper(companyTypeDomainService.deleteCompanyType(typeId));
	}
}
