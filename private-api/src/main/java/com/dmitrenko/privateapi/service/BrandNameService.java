package com.dmitrenko.privateapi.service;

import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;

public interface BrandNameService {

	ObjectResponse<BrandNameResponse> addBrandName(BrandNameRequest request);

	ListResponse<BrandNameResponse> addBrandNames(BrandNamesRequest request);

	ObjectResponse<BrandNameResponse> getBrandName(Long brandNameId);

	ListResponse<BrandNameResponse> getAllBrandNames();

	ObjectResponse<BrandNameResponse> updateBrandName(Long brandNameId, BrandNameRequest request);

	SuccessWrapper deleteBrandName(Long brandNameId);

	SuccessWrapper deleteAllBrandNames();
}
