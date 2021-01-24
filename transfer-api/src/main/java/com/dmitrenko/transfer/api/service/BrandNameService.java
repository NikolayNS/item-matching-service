package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface BrandNameService {

	ObjectResponse<BrandNameResponse> addBrandName(BrandNameRequest request);

	ListResponse<BrandNameResponse> addBrandNames(BrandNamesRequest request);

	ObjectResponse<BrandNameResponse> getBrandName(Long brandNameId);

	ListResponse<BrandNameResponse> getAllBrandNames();

	ObjectResponse<BrandNameResponse> updateBrandName(Long brandNameId, BrandNameRequest request);

	SuccessWrapper deleteBrandName(Long brandNameId);

	SuccessWrapper deleteAllBrandNames();
}
