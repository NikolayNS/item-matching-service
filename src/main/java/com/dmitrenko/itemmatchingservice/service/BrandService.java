package com.dmitrenko.itemmatchingservice.service;

import com.dmitrenko.itemmatchingservice.dto.request.add.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.BrandDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.BrandGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.BrandUpdateRequest;
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
