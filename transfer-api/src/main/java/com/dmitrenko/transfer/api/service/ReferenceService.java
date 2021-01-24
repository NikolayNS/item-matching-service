package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface ReferenceService {

	ObjectResponse<ReferenceResponse> addReference(ReferenceRequest request);

	ObjectResponse<ReferenceResponse> getReference(Long referenceId);

	ListResponse<ReferenceResponse> getAllReferences();

	ObjectResponse<ReferenceResponse> updateReference(Long referenceId, ReferenceRequest request);

	SuccessWrapper deleteReference(Long referenceId);

	ObjectResponse<ReferenceTypeResponse> addReferenceType(ReferenceTypeRequest request);

	ObjectResponse<ReferenceTypeResponse> getReferenceType(Long typeId);

	ListResponse<ReferenceTypeResponse> getAllReferenceTypes();

	ObjectResponse<ReferenceTypeResponse> updateReferenceType(Long typeId, ReferenceTypeRequest request);

	SuccessWrapper deleteReferenceType(Long typeId);

	ObjectResponse<ReferenceFieldResponse> addReferenceField(ReferenceFieldRequest request);

	ListResponse<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request);

	ObjectResponse<ReferenceFieldResponse> getReferenceField(Long fieldId);

	ListResponse<ReferenceFieldResponse> getAllReferenceFields();

	ObjectResponse<ReferenceFieldResponse> updateReferenceField(Long typeId, ReferenceFieldRequest request);

	ListResponse<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	SuccessWrapper deleteReferenceField(Long fieldId);

	SuccessWrapper deleteAllReferenceFieldsByReferenceId(Long referenceId);
}
