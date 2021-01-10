package com.dmitrenko.database.service.domain.brandname;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;

import java.util.List;

public interface BrandNameDomainService {

	BrandNameResponse addBrandName(BrandNameRequest request);

	List<BrandNameResponse> addBrandNames(BrandNamesRequest request);

	BrandNameResponse getBrandName(Long brandNameId);

	List<BrandNameResponse> getAllBrandNames();

	BrandNameResponse updateBrandName(Long brandNameId, BrandNameRequest request);

	void deleteBrandName(Long brandNameId);

	void deleteAllBrandNames();
}
