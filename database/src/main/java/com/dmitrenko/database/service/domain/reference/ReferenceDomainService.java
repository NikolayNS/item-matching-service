package com.dmitrenko.database.service.domain.reference;

import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;

import java.util.List;

public interface ReferenceDomainService {

	ReferenceResponse addReference(ReferenceRequest request);

	ReferenceResponse getReference(Long referenceId);

	List<ReferenceResponse> getAllReferences();

	ReferenceResponse updateReference(Long referenceId, ReferenceRequest request);

	boolean deleteReference(Long referenceId);
}
