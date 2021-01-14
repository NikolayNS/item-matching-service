package com.dmitrenko.database.service;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;

import java.util.List;

public interface ReferenceService {

	ReferenceResponse addReference(ReferenceRequest request);

	ReferenceResponse getReference(Long referenceId);

	List<ReferenceResponse> getAllReferences();

	ReferenceResponse updateReference(Long referenceId, ReferenceRequest request);

	boolean deleteReference(Long referenceId);

	ReferenceTypeResponse addReferenceType(ReferenceTypeRequest request);

	ReferenceTypeResponse getReferenceType(Long typeId);

	List<ReferenceTypeResponse> getAllReferenceTypes();

	ReferenceTypeResponse updateReferenceType(Long typeId, ReferenceTypeRequest request);

	boolean deleteReferenceType(Long typeId);

	ReferenceFieldResponse addReferenceField(ReferenceFieldRequest request);

	List<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request);

	ReferenceFieldResponse getReferenceField(Long fieldId);

	List<ReferenceFieldResponse> getAllReferenceFields();

	ReferenceFieldResponse updateReferenceField(Long typeId, ReferenceFieldRequest request);

	List<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	boolean deleteReferenceField(Long fieldId);

	boolean deleteAllReferenceFieldsByReferenceId(Long referenceId);
}
