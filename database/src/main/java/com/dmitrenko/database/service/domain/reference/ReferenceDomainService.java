package com.dmitrenko.database.service.domain.reference;

import com.dmitrenko.database.dto.request.reference.ReferenceAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;

import java.util.List;

public interface ReferenceDomainService {

	ReferenceResponse addReference(ReferenceAddRequest request);

	ReferenceResponse getReference(Long referenceId);

	List<ReferenceResponse> getAllReferences();

	ReferenceResponse updateReference(Long referenceId, ReferenceUpdateRequest request);

	boolean deleteReference(Long referenceId);
}
