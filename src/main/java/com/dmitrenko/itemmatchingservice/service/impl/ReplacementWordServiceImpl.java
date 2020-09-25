package com.dmitrenko.itemmatchingservice.service.impl;

import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.replacementword.ReplacementWordUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ReplacementWordResponse;
import com.dmitrenko.itemmatchingservice.service.ReplacementWordService;
import com.dmitrenko.itemmatchingservice.service.domain.ReplacementWordDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplacementWordServiceImpl implements ReplacementWordService {

	private final ReplacementWordDomainService domainService;

	@Override
	public ReplacementWordResponse add(ReplacementWordAddRequest request) {
		return domainService.add(request);
	}

	@Override
	public ReplacementWordResponse get(ReplacementWordGetRequest request) {
		return domainService.get(request);
	}

	@Override
	public List<ReplacementWordResponse> getAll() {
		return domainService.getAll();
	}

	@Override
	public ReplacementWordResponse update(ReplacementWordUpdateRequest request) {
		return domainService.update(request);
	}

	@Override
	public void delete(ReplacementWordDeleteRequest request) {
		domainService.delete(request);
	}

	@Override
	public void deleteAll() {
		domainService.deleteAll();
	}
}
