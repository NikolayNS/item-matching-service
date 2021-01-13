package com.dmitrenko.database.service.domain.reference;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsDeleteRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;

import java.util.List;

public interface ReferenceFieldDomainService {

	ReferenceFieldResponse addReferenceField(ReferenceFieldAddRequest request);

	List<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsAddRequest request);

	ReferenceFieldResponse getReferenceField(Long fieldId);

	List<ReferenceFieldResponse> getAllReferenceFields();

	ReferenceFieldResponse updateReferenceField(Long typeId, ReferenceFieldUpdateRequest request);

	List<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	boolean deleteReferenceField(Long fieldId);

	boolean deleteReferenceFields(ReferenceFieldsDeleteRequest request);

	boolean deleteAllReferenceFieldsByReferenceId(Long referenceId);
}
