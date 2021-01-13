package com.dmitrenko.database.service.impl;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.service.ModifiedStringService;
import com.dmitrenko.database.service.domain.modifiedstring.ModifiedStringDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModifiedStringServiceImpl implements ModifiedStringService {

	private final ModifiedStringDomainService modifiedStringDomainService;

	@Override
	public ModifiedStringResponse addModifiedString(ModifiedStringRequest request) {
		return modifiedStringDomainService.addModifiedString(request);
	}

	@Override
	public List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request) {
		return modifiedStringDomainService.addModifiedStrings(request);
	}

	@Override
	public ModifiedStringResponse getModifiedString(Long modifiedStringId) {
		return modifiedStringDomainService.getModifiedString(modifiedStringId);
	}

	@Override
	public List<ModifiedStringResponse> getAllModifiedStrings() {
		return modifiedStringDomainService.getAllModifiedStrings();
	}

	@Override
	public ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringRequest request) {
		return modifiedStringDomainService.updateModifiedString(modifiedStringId, request);
	}

	@Override
	public boolean deleteModifiedString(Long modifiedStringId) {
		return modifiedStringDomainService.deleteModifiedString(modifiedStringId);
	}

	@Override
	public boolean deleteAllModifiedStrings() {
		return modifiedStringDomainService.deleteAllModifiedStrings();
	}
}
