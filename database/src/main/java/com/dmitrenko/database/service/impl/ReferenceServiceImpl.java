package com.dmitrenko.database.service.impl;

import com.dmitrenko.database.dto.request.reference.ReferenceAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsDeleteRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.database.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

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
	public void deleteReference(Long referenceId) {

	}

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
	public void deleteReferenceType(Long companyId) {

	}

	@Override
	public ReferenceFieldResponse addReferenceField(ReferenceFieldAddRequest request) {
		return null;
	}

	@Override
	public List<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsAddRequest request) {
		return null;
	}

	@Override
	public ReferenceFieldResponse getReferenceField(Long fieldId) {
		return null;
	}

	@Override
	public List<ReferenceFieldResponse> getAllReferenceFields() {
		return null;
	}

	@Override
	public ReferenceFieldResponse updateReferenceField(Long typeId, ReferenceFieldUpdateRequest request) {
		return null;
	}

	@Override
	public List<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request) {
		return null;
	}

	@Override
	public void deleteReferenceField(Long fieldId) {

	}

	@Override
	public void deleteReferenceFields(ReferenceFieldsDeleteRequest request) {

	}

	@Override
	public void deleteAllReferenceFieldsByReferenceId(Long referenceId) {

	}
}
