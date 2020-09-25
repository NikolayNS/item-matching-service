package com.dmitrenko.itemmatchingservice.service;

import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.BrandResponse;

import java.util.List;

public interface BrandService {

	BrandResponse add(BrandAddRequest request);

	BrandResponse get(BrandGetRequest request);

	List<BrandResponse> getAll();

	BrandResponse update(BrandUpdateRequest request);

	void delete(BrandDeleteRequest request);

	void deleteAll();
}
