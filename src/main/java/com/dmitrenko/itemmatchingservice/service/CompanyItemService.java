package com.dmitrenko.itemmatchingservice.service;

import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.CompanyItemResponse;

import java.util.List;

public interface CompanyItemService {

	CompanyItemResponse add(CompanyItemAddRequest request);

	CompanyItemResponse get(CompanyItemGetRequest request);

	List<CompanyItemResponse> getAll();

	CompanyItemResponse update(CompanyItemUpdateRequest request);

	void delete(CompanyItemDeleteRequest request);

	void deleteAll();
}
