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
import com.dmitrenko.database.service.domain.reference.ReferenceDomainService;
import com.dmitrenko.database.service.domain.reference.ReferenceFieldDomainService;
import com.dmitrenko.database.service.domain.reference.ReferenceTypeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

	private final ReferenceDomainService referenceDomainService;
	private final ReferenceTypeDomainService referenceTypeDomainService;
	private final ReferenceFieldDomainService referenceFieldDomainService;

	@Override
	public ReferenceResponse addReference(ReferenceAddRequest request) {
		return referenceDomainService.addReference(request);
	}

	@Override
	public ReferenceResponse getReference(Long referenceId) {
		return referenceDomainService.getReference(referenceId);
	}

	@Override
	public List<ReferenceResponse> getAllReferences() {
		return referenceDomainService.getAllReferences();
	}

	@Override
	public ReferenceResponse updateReference(Long referenceId, ReferenceUpdateRequest request) {
		return referenceDomainService.updateReference(referenceId, request);
	}

	@Override
	public boolean deleteReference(Long referenceId) {
		return referenceDomainService.deleteReference(referenceId);
	}

	@Override
	public ReferenceTypeResponse addReferenceType(ReferenceTypeAddRequest request) {
		return referenceTypeDomainService.addReferenceType(request);
	}

	@Override
	public ReferenceTypeResponse getReferenceType(Long typeId) {
		return referenceTypeDomainService.getReferenceType(typeId);
	}

	@Override
	public List<ReferenceTypeResponse> getAllReferenceTypes() {
		return referenceTypeDomainService.getAllReferenceTypes();
	}

	@Override
	public ReferenceTypeResponse updateReferenceType(Long typeId, ReferenceTypeUpdateRequest request) {
		return referenceTypeDomainService.updateReferenceType(typeId, request);
	}

	@Override
	public boolean deleteReferenceType(Long typeId) {
		return referenceTypeDomainService.deleteReferenceType(typeId);
	}

	@Override
	public ReferenceFieldResponse addReferenceField(ReferenceFieldAddRequest request) {
		return referenceFieldDomainService.addReferenceField(request);
	}

	@Override
	public List<ReferenceFieldResponse> addReferenceFields(ReferenceFieldsAddRequest request) {
		return referenceFieldDomainService.addReferenceFields(request);
	}

	@Override
	public ReferenceFieldResponse getReferenceField(Long fieldId) {
		return referenceFieldDomainService.getReferenceField(fieldId);
	}

	@Override
	public List<ReferenceFieldResponse> getAllReferenceFields() {
		return referenceFieldDomainService.getAllReferenceFields();
	}

	@Override
	public ReferenceFieldResponse updateReferenceField(Long typeId, ReferenceFieldUpdateRequest request) {
		return referenceFieldDomainService.updateReferenceField(typeId, request);
	}

	@Override
	public List<ReferenceFieldResponse> updateReferenceFields(ReferenceFieldsUpdateRequest request) {
		return referenceFieldDomainService.updateReferenceFields(request);
	}

	@Override
	public boolean deleteReferenceField(Long fieldId) {
		return referenceFieldDomainService.deleteReferenceField(fieldId);
	}

	@Override
	public boolean deleteReferenceFields(ReferenceFieldsDeleteRequest request) {
		return referenceFieldDomainService.deleteReferenceFields(request);
	}

	@Override
	public boolean deleteAllReferenceFieldsByReferenceId(Long referenceId) {
		return referenceFieldDomainService.deleteAllReferenceFieldsByReferenceId(referenceId);
	}
}
