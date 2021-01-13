package com.dmitrenko.database.service.impl;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.database.service.BrandNameService;
import com.dmitrenko.database.service.domain.brandname.BrandNameDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandNameServiceImpl implements BrandNameService {

	private final BrandNameDomainService brandNameDomainService;

	@Override
	public BrandNameResponse addBrandName(BrandNameRequest request) {
		return brandNameDomainService.addBrandName(request);
	}

	@Override
	public List<BrandNameResponse> addBrandNames(BrandNamesRequest request) {
		return brandNameDomainService.addBrandNames(request);
	}

	@Override
	public BrandNameResponse getBrandName(Long brandNameId) {
		return brandNameDomainService.getBrandName(brandNameId);
	}

	@Override
	public List<BrandNameResponse> getAllBrandNames() {
		return brandNameDomainService.getAllBrandNames();
	}

	@Override
	public BrandNameResponse updateBrandName(Long brandNameId, BrandNameRequest request) {
		return brandNameDomainService.updateBrandName(brandNameId, request);
	}

	@Override
	public boolean deleteBrandName(Long brandNameId) {
		return brandNameDomainService.deleteBrandName(brandNameId);
	}

	@Override
	public boolean deleteAllBrandNames() {
		return brandNameDomainService.deleteAllBrandNames();
	}
}
