package com.dmitrenko.itemmatchingservice.service.domain.impl;

import com.dmitrenko.itemmatchingservice.dto.request.add.ReplacementWordAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.ReplacementWordDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.ReplacementWordGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.ReplacementWordUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ReplacementWordResponse;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.domain.ReplacementWordMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.response.ReplacementWordResponseMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.update.ReplacementWordMerger;
import com.dmitrenko.itemmatchingservice.repository.ReplacementWordRepository;
import com.dmitrenko.itemmatchingservice.service.domain.ReplacementWordDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplacementWordDomainServiceImpl implements ReplacementWordDomainService {

	private final ReplacementWordRepository repository;
	private final ApplicationContext context;

	@Override
	@Transactional
	public ReplacementWordResponse add(ReplacementWordAddRequest request) {
		checkEntityAlreadyExists(request.getReplacement());

		var entityMapper = context.getBean(ReplacementWordMapper.class);
		var responseMapper = context.getBean(ReplacementWordResponseMapper.class);

		var entity = entityMapper.from(request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public ReplacementWordResponse get(ReplacementWordGetRequest request) {
		checkEntityExists(request.getId());

		var responseMapper = context.getBean(ReplacementWordResponseMapper.class);

		return responseMapper.from(repository.getOne(request.getId()));
	}

	@Override
	@Transactional
	public List<ReplacementWordResponse> getAll() {
		var responseMapper = context.getBean(ReplacementWordResponseMapper.class);

		return responseMapper.from(repository.findAll());
	}

	@Override
	@Transactional
	public ReplacementWordResponse update(ReplacementWordUpdateRequest request) {
		checkEntityExists(request.getId());

		var updateMerger = context.getBean(ReplacementWordMerger.class);
		var responseMapper = context.getBean(ReplacementWordResponseMapper.class);

		var entity = updateMerger.merge(repository.getOne(request.getId()), request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public void delete(ReplacementWordDeleteRequest request) {
		checkEntityExists(request.getId());

		repository.deleteById(request.getId());
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}

	private void checkEntityAlreadyExists(String name) {
		if (isEntityExistByName(name))
			throw new InvalidParametersException("Brand with name: " + name + " already exists.");
	}

	private boolean isEntityExistByName(String replacement) {
		return repository.existsByReplacement(replacement);
	}

	private void checkEntityExists(Long id) {
		if (!isEntityExists(id))
			throw new InvalidParametersException("Brand with id: " + id + " does not exists.");
	}

	private boolean isEntityExists(Long id) {
		return repository.existsById(id);
	}
}
