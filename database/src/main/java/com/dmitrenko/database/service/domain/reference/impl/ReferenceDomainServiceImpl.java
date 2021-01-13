package com.dmitrenko.database.service.domain.reference.impl;

import com.dmitrenko.database.dto.request.reference.ReferenceAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.service.domain.reference.ReferenceDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceDomainServiceImpl implements ReferenceDomainService {

	@Override
	public ReferenceResponse addReference(ReferenceAddRequest request) {
		return null;
	}

	@Override
	public ReferenceResponse getReference(Long referenceId) {
		return null;
	}

	@Override
	public List<ReferenceResponse> getAllReferences() {
		return null;
	}

	@Override
	public ReferenceResponse updateReference(Long referenceId, ReferenceUpdateRequest request) {
		return null;
	}

	@Override
	public boolean deleteReference(Long referenceId) {
		return true;
	}
}
