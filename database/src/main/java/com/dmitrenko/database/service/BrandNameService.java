package com.dmitrenko.database.service;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesAddRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;

import java.util.List;

public interface BrandNameService {

	BrandNameResponse addBrandName(BrandNameRequest request);

	List<BrandNameResponse> addBrandNames(BrandNamesAddRequest request);

	BrandNameResponse getBrandName(Long brandNameId);

	List<BrandNameResponse> getAllBrandNames();

	BrandNameResponse updateBrandName(Long brandNameId, BrandNameRequest request);

	void deleteBrandName(Long brandNameId);

	void deleteAllBrandNames();
}
