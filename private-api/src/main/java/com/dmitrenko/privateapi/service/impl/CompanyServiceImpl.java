package com.dmitrenko.privateapi.service.impl;

import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.service.domain.company.CompanyDomainService;
import com.dmitrenko.privateapi.service.CompanyService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyDomainService companyDomainService;

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
}
