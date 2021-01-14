package com.dmitrenko.database.service.domain.reference;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;

import java.util.List;

public interface ReferenceFieldDomainService {

	ReferenceFieldResponse addReferenceField(ReferenceFieldRequest request);

	List<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request);

	ReferenceFieldResponse getReferenceField(Long fieldId);

	List<ReferenceFieldResponse> getAllReferenceFields();

	ReferenceFieldResponse updateReferenceField(Long fieldId, ReferenceFieldRequest request);

	List<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	boolean deleteReferenceField(Long fieldId);

	boolean deleteAllReferenceFieldsByReferenceId(Long referenceId);
}
