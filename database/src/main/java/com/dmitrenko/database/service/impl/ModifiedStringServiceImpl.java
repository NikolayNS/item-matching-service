package com.dmitrenko.database.service.impl;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.service.ModifiedStringService;
import com.dmitrenko.database.service.domain.modifiedstring.ItemModifiedStringDomainService;
import com.dmitrenko.database.service.domain.modifiedstring.ModifiedStringDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModifiedStringServiceImpl implements ModifiedStringService {

	private final ModifiedStringDomainService modifiedStringDomainService;
	private final ItemModifiedStringDomainService itemModifiedStringDomainService;

	@Override
	public ModifiedStringResponse addModifiedString(ModifiedStringRequest request) {
		return null;
	}

	@Override
	public List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request) {
		return null;
	}

	@Override
	public ModifiedStringResponse getModifiedString(Long modifiedStringId) {
		return null;
	}

	@Override
	public List<ModifiedStringResponse> getAllModifiedStrings() {
		return null;
	}

	@Override
	public ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringRequest request) {
		return null;
	}

	@Override
	public void deleteModifiedString(Long modifiedStringId) {

	}

	@Override
	public void deleteAllModifiedStrings() {

	}
}
