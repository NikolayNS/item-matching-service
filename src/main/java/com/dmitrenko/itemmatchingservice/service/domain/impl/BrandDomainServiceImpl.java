package com.dmitrenko.itemmatchingservice.service.domain.impl;

import com.dmitrenko.itemmatchingservice.dto.request.add.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.delete.BrandDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.get.BrandGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.update.BrandUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.BrandResponse;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.domain.BrandMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.response.BrandResponseMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.update.BrandMerger;
import com.dmitrenko.itemmatchingservice.repository.BrandRepository;
import com.dmitrenko.itemmatchingservice.service.domain.BrandDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandDomainServiceImpl implements BrandDomainService {

	private final BrandRepository repository;
	private final ApplicationContext context;

	@Override
	@Transactional
	public BrandResponse add(BrandAddRequest request) {
		checkEntityAlreadyExists(request.getName());

		var entityMapper = context.getBean(BrandMapper.class);
		var responseMapper = context.getBean(BrandResponseMapper.class);

		var entity = entityMapper.from(request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public BrandResponse get(BrandGetRequest request) {
		checkEntityExists(request.getId());

		var responseMapper = context.getBean(BrandResponseMapper.class);

		return responseMapper.from(repository.getOne(request.getId()));
	}

	@Override
	@Transactional
	public List<BrandResponse> getAll() {

		var responseMapper = context.getBean(BrandResponseMapper.class);

		return responseMapper.from(repository.findAll());
	}

	@Override
	@Transactional
	public BrandResponse update(BrandUpdateRequest request) {
		checkEntityExists(request.getId());

		var updateMerger = context.getBean(BrandMerger.class);
		var responseMapper = context.getBean(BrandResponseMapper.class);

		var entity = updateMerger.merge(repository.getOne(request.getId()), request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public void delete(BrandDeleteRequest request) {
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

	private boolean isEntityExistByName(String name) {
		return repository.existsByName(name);
	}

	private void checkEntityExists(Long id) {
		if (!isEntityExists(id))
			throw new InvalidParametersException("Brand with id: " + id + " does not exists.");
	}

	private boolean isEntityExists(Long id) {
		return repository.existsById(id);
	}
}
