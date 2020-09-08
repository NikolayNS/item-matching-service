package com.dmitrenko.itemmatchingservice.service.domain;

import com.dmitrenko.itemmatchingservice.dto.request.add.ReplacementWordAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.ReplacementWordDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.ReplacementWordGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.ReplacementWordUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ReplacementWordResponse;

import java.util.List;

public interface ReplacementWordDomainService {

	ReplacementWordResponse add(ReplacementWordAddRequest request);

	ReplacementWordResponse get(ReplacementWordGetRequest request);

	List<ReplacementWordResponse> getAll();

	ReplacementWordResponse update(ReplacementWordUpdateRequest request);

	void delete(ReplacementWordDeleteRequest request);

	void deleteAll();
}
