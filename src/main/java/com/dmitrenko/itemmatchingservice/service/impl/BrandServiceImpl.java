package com.dmitrenko.itemmatchingservice.service.impl;

import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.BrandResponse;
import com.dmitrenko.itemmatchingservice.service.BrandService;
import com.dmitrenko.itemmatchingservice.service.domain.BrandDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

	private final BrandDomainService domainService;

	@Override
	public BrandResponse add(BrandAddRequest request) {
		return domainService.add(request);
	}

	@Override
	public BrandResponse get(BrandGetRequest request) {
		return domainService.get(request);
	}

	@Override
	public List<BrandResponse> getAll() {
		return domainService.getAll();
	}

	@Override
	public BrandResponse update(BrandUpdateRequest request) {
		return domainService.update(request);
	}

	@Override
	public void delete(BrandDeleteRequest request) {
		domainService.delete(request);
	}

	@Override
	public void deleteAll() {
		domainService.deleteAll();
	}
}
