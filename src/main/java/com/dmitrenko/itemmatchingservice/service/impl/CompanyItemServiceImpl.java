package com.dmitrenko.itemmatchingservice.service.impl;

import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.CompanyItemResponse;
import com.dmitrenko.itemmatchingservice.service.CompanyItemService;
import com.dmitrenko.itemmatchingservice.service.domain.CompanyItemDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyItemServiceImpl implements CompanyItemService {

	private final CompanyItemDomainService domainService;

	@Override
	public CompanyItemResponse add(CompanyItemAddRequest request) {
		return domainService.add(request);
	}

	@Override
	public CompanyItemResponse get(CompanyItemGetRequest request) {
		return domainService.get(request);
	}

	@Override
	public List<CompanyItemResponse> getAll() {
		return domainService.getAll();
	}

	@Override
	public CompanyItemResponse update(CompanyItemUpdateRequest request) {
		return domainService.update(request);
	}

	@Override
	public void delete(CompanyItemDeleteRequest request) {
		domainService.delete(request);
	}

	@Override
	public void deleteAll() {
		domainService.deleteAll();
	}
}
