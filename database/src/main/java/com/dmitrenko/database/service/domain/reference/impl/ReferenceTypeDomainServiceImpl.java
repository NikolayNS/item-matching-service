package com.dmitrenko.database.service.domain.reference.impl;

import com.dmitrenko.database.dto.request.reference.ReferenceTypeAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.database.service.domain.reference.ReferenceTypeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceTypeDomainServiceImpl implements ReferenceTypeDomainService {

	@Override
	public ReferenceTypeResponse addReferenceType(ReferenceTypeAddRequest request) {
		return null;
	}

	@Override
	public ReferenceTypeResponse getReferenceType(Long typeId) {
		return null;
	}

	@Override
	public List<ReferenceTypeResponse> getAllReferenceTypes() {
		return null;
	}

	@Override
	public ReferenceTypeResponse updateReferenceType(Long typeId, ReferenceTypeUpdateRequest request) {
		return null;
	}

	@Override
	public boolean deleteReferenceType(Long companyId) {
		return true;
	}
}
