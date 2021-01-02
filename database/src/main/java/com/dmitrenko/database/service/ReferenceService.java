package com.dmitrenko.database.service;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.database.dto.request.productgroup.ProductGroupAddRequest;
import com.dmitrenko.database.dto.request.productgroup.ProductGroupDeleteRequest;
import com.dmitrenko.database.dto.request.productgroup.ProductGroupGetRequest;
import com.dmitrenko.database.dto.request.productgroup.ProductGroupUpdateRequest;

import java.util.List;

public interface ReferenceService {

	ProductGroupResponse add(ProductGroupAddRequest request);

	ProductGroupResponse get(ProductGroupGetRequest request);

	List<ProductGroupResponse> getAll();

	ProductGroupResponse update(ProductGroupUpdateRequest request);

	void delete(ProductGroupDeleteRequest request);

	void deleteAll();
}
