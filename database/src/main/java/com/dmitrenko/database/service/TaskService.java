package com.dmitrenko.database.service;

import com.dmitrenko.database.dto.request.replacementword.ReplacementWordAddRequest;
import com.dmitrenko.database.dto.request.replacementword.ReplacementWordDeleteRequest;
import com.dmitrenko.database.dto.request.replacementword.ReplacementWordGetRequest;
import com.dmitrenko.database.dto.request.replacementword.ReplacementWordUpdateRequest;

import java.util.List;

public interface TaskService {

	ReplacementWordResponse add(ReplacementWordAddRequest request);

	ReplacementWordResponse get(ReplacementWordGetRequest request);

	List<ReplacementWordResponse> getAll();

	ReplacementWordResponse update(ReplacementWordUpdateRequest request);

	void delete(ReplacementWordDeleteRequest request);

	void deleteAll();
}
