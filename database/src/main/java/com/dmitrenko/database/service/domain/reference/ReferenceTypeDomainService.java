package com.dmitrenko.database.service.domain.reference;

import com.dmitrenko.database.dto.request.reference.ReferenceTypeAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;

import java.util.List;

public interface ReferenceTypeDomainService {

	ReferenceTypeResponse addReferenceType(ReferenceTypeAddRequest request);

	ReferenceTypeResponse getReferenceType(Long typeId);

	List<ReferenceTypeResponse> getAllReferenceTypes();

	ReferenceTypeResponse updateReferenceType(Long typeId, ReferenceTypeUpdateRequest request);

	boolean deleteReferenceType(Long companyId);
}
