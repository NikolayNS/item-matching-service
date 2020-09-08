package com.dmitrenko.itemmatchingservice.service.domain;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.request.add.ProductGroupAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.ProductGroupDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.ProductGroupGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.ProductGroupUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ProductGroupResponse;

import java.util.List;

public interface ProductGroupDomainService {

	ProductGroupResponse add(ProductGroupAddRequest request);

	ProductGroupResponse get(ProductGroupGetRequest request);

	List<ProductGroupResponse> getAll();

	ProductGroupResponse update(ProductGroupUpdateRequest request);

	void delete(ProductGroupDeleteRequest request);

	void deleteAll();

	ProductGroup getById(Long id);
}
