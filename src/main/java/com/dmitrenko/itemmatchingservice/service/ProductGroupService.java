package com.dmitrenko.itemmatchingservice.service;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ProductGroupResponse;

import java.util.List;

public interface ProductGroupService {

	ProductGroupResponse add(ProductGroupAddRequest request);

	ProductGroupResponse get(ProductGroupGetRequest request);

	List<ProductGroupResponse> getAll();

	ProductGroupResponse update(ProductGroupUpdateRequest request);

	void delete(ProductGroupDeleteRequest request);

	void deleteAll();
}
