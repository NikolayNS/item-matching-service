package com.dmitrenko.database.service.domain.reference.impl;

import com.dmitrenko.database.domain.reference.ReferenceType;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceTypeMapper;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceTypeMerger;
import com.dmitrenko.database.mapper.impl.response.reference.ReferenceTypeResponseMapper;
import com.dmitrenko.database.repository.ReferenceTypeRepository;
import com.dmitrenko.database.service.domain.reference.ReferenceTypeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceTypeDomainServiceImpl implements ReferenceTypeDomainService {

	private final ReferenceTypeRepository referenceTypeRepository;

	private final ReferenceTypeMapper referenceTypeMapper;
	private final ReferenceTypeMerger referenceTypeMerger;
	private final ReferenceTypeResponseMapper referenceTypeResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReferenceTypeResponse addReferenceType(@Valid ReferenceTypeRequest request) {
		if (referenceTypeRepository.findByName(request.getName()).isPresent()) {
			throw new EntityAlreadyExistException(String.format("Reference type with name %s already exist", request.getName()));
		}

		var type = referenceTypeMapper.from(request);
		type = referenceTypeRepository.saveAndFlush(type);

		return referenceTypeResponseMapper.from(type);
	}

	@Override
	@Transactional(readOnly = true)
	public ReferenceTypeResponse getReferenceType(Long typeId) {
		return referenceTypeResponseMapper.from(getEntity(typeId));
	}

	private ReferenceType getEntity(Long id) {
		return referenceTypeRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Reference type with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReferenceTypeResponse> getAllReferenceTypes() {
		return referenceTypeResponseMapper.from(referenceTypeRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReferenceTypeResponse updateReferenceType(Long typeId, @Valid ReferenceTypeRequest request) {
		var type = getEntity(typeId);
		type = referenceTypeMerger.merge(type, request);

		type = referenceTypeRepository.saveAndFlush(type);

		return referenceTypeResponseMapper.from(type);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteReferenceType(Long typeId) {
		referenceTypeRepository.delete(getEntity(typeId));
		return referenceTypeRepository.existsById(typeId);
	}
}
