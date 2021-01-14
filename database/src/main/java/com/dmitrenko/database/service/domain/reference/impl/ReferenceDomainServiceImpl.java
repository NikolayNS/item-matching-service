package com.dmitrenko.database.service.domain.reference.impl;

import com.dmitrenko.database.domain.reference.Reference;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceMapper;
import com.dmitrenko.database.mapper.impl.domain.reference.ReferenceMerger;
import com.dmitrenko.database.mapper.impl.response.reference.ReferenceResponseMapper;
import com.dmitrenko.database.repository.ReferenceRepository;
import com.dmitrenko.database.service.domain.reference.ReferenceDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceDomainServiceImpl implements ReferenceDomainService {

	private final ReferenceRepository referenceRepository;

	private final ReferenceMapper referenceMapper;
	private final ReferenceMerger referenceMerger;
	private final ReferenceResponseMapper referenceResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReferenceResponse addReference(@Valid ReferenceRequest request) {
		if (referenceRepository.findByName(request.getName()).isPresent()) {
			throw new EntityAlreadyExistException(String.format("Reference with name %s already exist", request.getName()));
		}

		var reference = referenceMapper.from(request);
		reference = referenceRepository.saveAndFlush(reference);

		return referenceResponseMapper.from(reference);
	}

	@Override
	@Transactional(readOnly = true)
	public ReferenceResponse getReference(Long referenceId) {
		return referenceResponseMapper.from(getEntity(referenceId));
	}

	private Reference getEntity(Long id) {
		return referenceRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Reference with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReferenceResponse> getAllReferences() {
		return referenceResponseMapper.from(referenceRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReferenceResponse updateReference(Long referenceId, @Valid ReferenceRequest request) {
		var reference = getEntity(referenceId);
		reference = referenceMerger.merge(reference, request);

		reference = referenceRepository.saveAndFlush(reference);

		return referenceResponseMapper.from(reference);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteReference(Long referenceId) {
		referenceRepository.delete(getEntity(referenceId));
		return referenceRepository.existsById(referenceId);
	}
}
