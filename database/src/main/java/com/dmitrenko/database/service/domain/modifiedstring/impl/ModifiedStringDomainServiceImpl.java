package com.dmitrenko.database.service.domain.modifiedstring.impl;

import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.repository.ModifiedStringRepository;
import com.dmitrenko.database.service.domain.modifiedstring.ModifiedStringDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModifiedStringDomainServiceImpl implements ModifiedStringDomainService {

	private final ModifiedStringRepository modifiedStringRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ModifiedStringResponse addModifiedString(ModifiedStringRequest request) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ModifiedStringResponse getModifiedString(Long modifiedStringId) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModifiedStringResponse> getAllModifiedStrings() {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringRequest request) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteModifiedString(Long modifiedStringId) {

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteAllModifiedStrings() {

	}
}
