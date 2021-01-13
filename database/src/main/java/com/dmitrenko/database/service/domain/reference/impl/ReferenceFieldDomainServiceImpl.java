package com.dmitrenko.database.service.domain.reference.impl;

import com.dmitrenko.database.dto.request.reference.ReferenceFieldAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldUpdateRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsAddRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsDeleteRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.service.domain.reference.ReferenceFieldDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceFieldDomainServiceImpl implements ReferenceFieldDomainService {

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
	public boolean deleteReferenceField(Long fieldId) {
		return true;
	}

	@Override
	public boolean deleteReferenceFields(ReferenceFieldsDeleteRequest request) {
		return true;
	}

	@Override
	public boolean deleteAllReferenceFieldsByReferenceId(Long referenceId) {
		return true;
	}
}
