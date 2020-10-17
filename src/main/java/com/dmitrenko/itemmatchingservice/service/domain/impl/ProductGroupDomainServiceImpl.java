package com.dmitrenko.itemmatchingservice.service.domain.impl;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ProductGroupResponse;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.domain.ProductGroupMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.response.ProductGroupResponseMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.update.ProductGroupMerger;
import com.dmitrenko.itemmatchingservice.repository.ProductGroupRepository;
import com.dmitrenko.itemmatchingservice.service.domain.ProductGroupDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGroupDomainServiceImpl implements ProductGroupDomainService {

	private final ProductGroupRepository repository;
	private final ApplicationContext context;

	@Override
	@Transactional
	public ProductGroupResponse add(ProductGroupAddRequest request) {
		checkEntityAlreadyExists(request.getName());

		var entityMapper = context.getBean(ProductGroupMapper.class);
		var responseMapper = context.getBean(ProductGroupResponseMapper.class);

		var entity = entityMapper.from(request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public ProductGroupResponse get(ProductGroupGetRequest request) {
		checkEntityExists(request.getId());

		var responseMapper = context.getBean(ProductGroupResponseMapper.class);

		return responseMapper.from(repository.getOne(request.getId()));
	}

	@Override
	@Transactional
	public List<ProductGroupResponse> getAll() {
		var responseMapper = context.getBean(ProductGroupResponseMapper.class);

		return responseMapper.from(repository.findAll());
	}

	@Override
	@Transactional
	public ProductGroupResponse update(ProductGroupUpdateRequest request) {
		checkEntityExists(request.getId());

		var updateMerger = context.getBean(ProductGroupMerger.class);
		var responseMapper = context.getBean(ProductGroupResponseMapper.class);

		var entity = updateMerger.merge(repository.getOne(request.getId()), request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public void delete(ProductGroupDeleteRequest request) {
		checkEntityExists(request.getId());

		repository.deleteById(request.getId());
	}

	@Override
	@Transactional
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public ProductGroup getById(Long id) {
		checkEntityExists(id);

		return repository.getOne(id);
	}

	private void checkEntityAlreadyExists(String name) {
		if (isEntityExistByName(name))
			throw new InvalidParametersException("Product group with name: " + name + " already exists.");
	}

	private boolean isEntityExistByName(String name) {
		return repository.existsByName(name);
	}

	private void checkEntityExists(Long id) {
		if (!isEntityExists(id))
			throw new InvalidParametersException("Product group with id: " + id + " does not exists.");
	}

	private boolean isEntityExists(Long id) {
		return repository.existsById(id);
	}
}
