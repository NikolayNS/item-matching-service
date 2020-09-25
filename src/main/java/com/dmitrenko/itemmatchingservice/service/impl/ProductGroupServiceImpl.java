package com.dmitrenko.itemmatchingservice.service.impl;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ProductGroupResponse;
import com.dmitrenko.itemmatchingservice.service.ProductGroupService;
import com.dmitrenko.itemmatchingservice.service.domain.ProductGroupDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGroupServiceImpl implements ProductGroupService {

	private final ProductGroupDomainService domainService;

	@Override
	public ProductGroupResponse add(ProductGroupAddRequest request) {
		return domainService.add(request);
	}

	@Override
	public ProductGroupResponse get(ProductGroupGetRequest request) {
		return domainService.get(request);
	}

	@Override
	public List<ProductGroupResponse> getAll() {
		return domainService.getAll();
	}

	@Override
	public ProductGroupResponse update(ProductGroupUpdateRequest request) {
		return domainService.update(request);
	}

	@Override
	public void delete(ProductGroupDeleteRequest request) {
		domainService.delete(request);
	}

	@Override
	public void deleteAll() {
		domainService.deleteAll();
	}

	@Override
	public ProductGroup getById(Long id) {
		return domainService.getById(id);
	}
}
