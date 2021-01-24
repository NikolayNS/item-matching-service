package com.dmitrenko.transfer.api.service.impl;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.service.domain.modifiedstring.ModifiedStringDomainService;
import com.dmitrenko.transfer.api.service.ModifiedStringService;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifiedStringServiceImpl implements ModifiedStringService {

	private final ModifiedStringDomainService modifiedStringDomainService;

	@Override
	public ObjectResponse<ModifiedStringResponse> addModifiedString(ModifiedStringRequest request) {
		return ObjectResponse.success(modifiedStringDomainService.addModifiedString(request));
	}

	@Override
	public ListResponse<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request) {
		return ListResponse.success(modifiedStringDomainService.addModifiedStrings(request));
	}

	@Override
	public ObjectResponse<ModifiedStringResponse> getModifiedString(Long modifiedStringId) {
		return ObjectResponse.success(modifiedStringDomainService.getModifiedString(modifiedStringId));
	}

	@Override
	public ListResponse<ModifiedStringResponse> getAllModifiedStrings() {
		return ListResponse.success(modifiedStringDomainService.getAllModifiedStrings());
	}

	@Override
	public ObjectResponse<ModifiedStringResponse> updateModifiedString(Long modifiedStringId, ModifiedStringRequest request) {
		return ObjectResponse.success(modifiedStringDomainService.updateModifiedString(modifiedStringId, request));
	}

	@Override
	public SuccessWrapper deleteModifiedString(Long modifiedStringId) {
		return new SuccessWrapper(modifiedStringDomainService.deleteModifiedString(modifiedStringId));
	}

	@Override
	public SuccessWrapper deleteAllModifiedStrings() {
		return new SuccessWrapper(modifiedStringDomainService.deleteAllModifiedStrings());
	}
}
