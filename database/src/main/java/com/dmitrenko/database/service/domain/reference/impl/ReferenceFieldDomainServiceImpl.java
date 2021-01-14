package com.dmitrenko.database.service.domain.reference.impl;

import com.dmitrenko.database.domain.reference.ReferenceField;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsRequest;
import com.dmitrenko.database.dto.request.reference.ReferenceFieldsUpdateRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceFieldMapper;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceFieldMerger;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceFieldUpdateMerger;
import com.dmitrenko.database.mapper.impl.response.reference.ReferenceFieldResponseMapper;
import com.dmitrenko.database.repository.ReferenceFieldRepository;
import com.dmitrenko.database.service.domain.reference.ReferenceFieldDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReferenceFieldDomainServiceImpl implements ReferenceFieldDomainService {

	private final ReferenceFieldRepository referenceFieldRepository;

	private final ReferenceFieldMapper referenceFieldMapper;
	private final ReferenceFieldMerger referenceFieldMerger;
	private final ReferenceFieldUpdateMerger referenceFieldUpdateMerger;
	private final ReferenceFieldResponseMapper referenceFieldResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReferenceFieldResponse addReferenceField(@Valid ReferenceFieldRequest request) {
		if (referenceFieldRepository.findByBarcode(request.getBarcode()).isPresent())
			throw new EntityAlreadyExistException(String.format("ReferenceField with barcode %s already exist", request.getBarcode()));

		var field = referenceFieldMapper.from(request);
		field = referenceFieldRepository.saveAndFlush(field);

		return referenceFieldResponseMapper.from(field);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ReferenceFieldResponse> addReferenceFields(@Valid ReferenceFieldsRequest request) {
		return referenceFieldResponseMapper.from(request.getFields()
			.stream()
			.filter(referenceFieldsRequest -> referenceFieldRepository.findByBarcode(referenceFieldsRequest.getBarcode()).isEmpty())
			.map(referenceFieldRequest -> referenceFieldRepository.saveAndFlush(referenceFieldMapper.from(referenceFieldRequest)))
			.collect(Collectors.toList()));
	}

	@Override
	@Transactional(readOnly = true)
	public ReferenceFieldResponse getReferenceField(Long fieldId) {
		return referenceFieldResponseMapper.from(getEntity(fieldId));
	}

	private ReferenceField getEntity(Long id) {
		return referenceFieldRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Reference field with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReferenceFieldResponse> getAllReferenceFields() {
		return referenceFieldResponseMapper.from(referenceFieldRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReferenceFieldResponse updateReferenceField(Long fieldId, @Valid ReferenceFieldRequest request) {
		var field = getEntity(fieldId);
		field = referenceFieldMerger.merge(field, request);

		field = referenceFieldRepository.saveAndFlush(field);

		return referenceFieldResponseMapper.from(field);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ReferenceFieldResponse> updateReferenceFields(@Valid ReferenceFieldsUpdateRequest request) {
		return referenceFieldResponseMapper.from(request.getFields()
			.stream()
			.map(referenceFieldUpdateRequest -> referenceFieldRepository
				.saveAndFlush(referenceFieldUpdateMerger
					.merge(getEntity(referenceFieldUpdateRequest.getId()), referenceFieldUpdateRequest)))
			.collect(Collectors.toList()));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteReferenceField(Long fieldId) {
		referenceFieldRepository.delete(getEntity(fieldId));
		return referenceFieldRepository.existsById(fieldId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteAllReferenceFieldsByReferenceId(Long referenceId) {
		referenceFieldRepository.deleteByReferenceId(referenceId);
		return referenceFieldRepository.existsByReferenceId(referenceId);
	}
}
