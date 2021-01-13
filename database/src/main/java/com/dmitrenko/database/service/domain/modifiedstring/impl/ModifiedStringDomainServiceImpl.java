package com.dmitrenko.database.service.domain.modifiedstring.impl;

import com.dmitrenko.database.domain.modifedstring.ModifiedString;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringRequest;
import com.dmitrenko.database.dto.request.modifiedstring.ModifiedStringsRequest;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.modifiedstring.ModifiedStringMapper;
import com.dmitrenko.database.mapper.impl.domain.modifiedstring.ModifiedStringMerger;
import com.dmitrenko.database.mapper.impl.response.modifiedstring.ModifiedStringResponseMapper;
import com.dmitrenko.database.repository.ModifiedStringRepository;
import com.dmitrenko.database.service.domain.modifiedstring.ModifiedStringDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModifiedStringDomainServiceImpl implements ModifiedStringDomainService {

	private final ModifiedStringRepository modifiedStringRepository;

	private final ModifiedStringMapper modifiedStringMapper;
	private final ModifiedStringMerger modifiedStringMerger;
	private final ModifiedStringResponseMapper modifiedStringResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ModifiedStringResponse addModifiedString(ModifiedStringRequest request) {
		if (modifiedStringRepository.findByModifiable(request.getModifiable()).isPresent())
			throw new EntityAlreadyExistException(String.format("ModifiedString with modifiable %s already exist", request.getModifiable()));

		var modifiedString = modifiedStringMapper.from(request);
		modifiedString = modifiedStringRepository.saveAndFlush(modifiedString);

		return modifiedStringResponseMapper.from(modifiedString);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ModifiedStringResponse> addModifiedStrings(ModifiedStringsRequest request) {
		return modifiedStringResponseMapper.from(request.getModifiedStrings()
			.stream()
			.filter(modifiedStringRequest -> modifiedStringRepository.findByModifiable(modifiedStringRequest.getModifiable()).isEmpty())
			.map(modifiedStringRequest -> modifiedStringRepository.saveAndFlush(modifiedStringMapper.from(modifiedStringRequest)))
			.collect(Collectors.toList()));
	}

	@Override
	@Transactional(readOnly = true)
	public ModifiedStringResponse getModifiedString(Long modifiedStringId) {
		return modifiedStringResponseMapper.from(getEntity(modifiedStringId));
	}

	private ModifiedString getEntity(Long id) {
		return modifiedStringRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("ModifiedString with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ModifiedStringResponse> getAllModifiedStrings() {
		return modifiedStringResponseMapper.from(modifiedStringRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ModifiedStringResponse updateModifiedString(Long modifiedStringId, ModifiedStringRequest request) {
		var modifiedString = getEntity(modifiedStringId);
		modifiedString = modifiedStringMerger.merge(modifiedString, request);

		modifiedString = modifiedStringRepository.saveAndFlush(modifiedString);

		return modifiedStringResponseMapper.from(modifiedString);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteModifiedString(Long modifiedStringId) {
		var modifiedString = getEntity(modifiedStringId);
		modifiedStringRepository.delete(modifiedString);

		return !modifiedStringRepository.existsById(modifiedStringId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteAllModifiedStrings() {
		modifiedStringRepository.deleteAll();
		return modifiedStringRepository.findAll().isEmpty();
	}
}
