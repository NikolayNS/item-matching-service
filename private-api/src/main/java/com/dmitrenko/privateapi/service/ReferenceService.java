package com.dmitrenko.privateapi.service;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;

public interface ReferenceService {

	ObjectResponse<ReferenceResponse> addReference(ReferenceRequest request);

	ObjectResponse<ReferenceResponse> getReference(Long referenceId);

	ListResponse<ReferenceResponse> getAllReferences();

	ObjectResponse<ReferenceResponse> updateReference(Long referenceId, ReferenceRequest request);

	SuccessWrapper deleteReference(Long referenceId);

	ObjectResponse<ReferenceFieldResponse> addReferenceField(ReferenceFieldRequest request);

	ListResponse<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsRequest request);

	ObjectResponse<ReferenceFieldResponse> getReferenceField(Long fieldId);

	ListResponse<ReferenceFieldResponse> getAllReferenceFields();

	ObjectResponse<ReferenceFieldResponse> updateReferenceField(Long typeId, ReferenceFieldRequest request);

	ListResponse<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request);

	SuccessWrapper deleteReferenceField(Long fieldId);

	SuccessWrapper deleteAllReferenceFieldsByReferenceId(Long referenceId);
}
