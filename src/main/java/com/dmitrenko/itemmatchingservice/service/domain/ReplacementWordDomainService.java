package com.dmitrenko.itemmatchingservice.service.domain;

import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordUpdateRequest;
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
