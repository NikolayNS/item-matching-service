package com.dmitrenko.itemmatchingservice.service;

import com.dmitrenko.itemmatchingservice.dto.request.add.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.CompanyItemDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.CompanyItemGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.CompanyItemUpdateRequest;
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
