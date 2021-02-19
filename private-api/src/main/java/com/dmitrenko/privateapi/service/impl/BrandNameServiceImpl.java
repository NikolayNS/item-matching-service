package com.dmitrenko.privateapi.service.impl;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.database.service.domain.brandname.BrandNameDomainService;
import com.dmitrenko.privateapi.service.BrandNameService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandNameServiceImpl implements BrandNameService {

	private final BrandNameDomainService brandNameDomainService;

	@Override
	public ObjectResponse<BrandNameResponse> addBrandName(BrandNameRequest request) {
		return ObjectResponse.success(brandNameDomainService.addBrandName(request));
	}

	@Override
	public ListResponse<BrandNameResponse> addBrandNames(BrandNamesRequest request) {
		return ListResponse.success(brandNameDomainService.addBrandNames(request));
	}

	@Override
	public ObjectResponse<BrandNameResponse> getBrandName(Long brandNameId) {
		return ObjectResponse.success(brandNameDomainService.getBrandName(brandNameId));
	}

	@Override
	public ListResponse<BrandNameResponse> getAllBrandNames() {
		return ListResponse.success(brandNameDomainService.getAllBrandNames());
	}

	@Override
	public ObjectResponse<BrandNameResponse> updateBrandName(Long brandNameId, BrandNameRequest request) {
		return ObjectResponse.success(brandNameDomainService.updateBrandName(brandNameId, request));
	}

	@Override
	public SuccessWrapper deleteBrandName(Long brandNameId) {
		return new SuccessWrapper(brandNameDomainService.deleteBrandName(brandNameId));
	}

	@Override
	public SuccessWrapper deleteAllBrandNames() {
		return new SuccessWrapper(brandNameDomainService.deleteAllBrandNames());
	}
}
