package com.dmitrenko.itemmatchingservice.service.domain.impl;

import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemDeleteRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemGetRequest;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemUpdateRequest;
import com.dmitrenko.itemmatchingservice.dto.response.CompanyItemResponse;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.domain.CompanyItemMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.response.CompanyItemResponseMapper;
import com.dmitrenko.itemmatchingservice.mapper.impl.update.CompanyItemMerger;
import com.dmitrenko.itemmatchingservice.repository.CompanyItemRepository;
import com.dmitrenko.itemmatchingservice.service.domain.CompanyItemDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyItemDomainServiceImpl implements CompanyItemDomainService {

	private final CompanyItemRepository repository;
	private final ApplicationContext context;

	@Override
	@Transactional
	public CompanyItemResponse add(CompanyItemAddRequest request) {
		checkEntityAlreadyExists(request.getName());

		var entityMapper = context.getBean(CompanyItemMapper.class);
		var responseMapper = context.getBean(CompanyItemResponseMapper.class);

		var entity = entityMapper.from(request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public CompanyItemResponse get(CompanyItemGetRequest request) {
		checkEntityExists(request.getId());

		var responseMapper = context.getBean(CompanyItemResponseMapper.class);

		return responseMapper.from(repository.getOne(request.getId()));
	}

	@Override
	@Transactional
	public List<CompanyItemResponse> getAll() {
		var responseMapper = context.getBean(CompanyItemResponseMapper.class);

		return responseMapper.from(repository.findAll());
	}

	@Override
	@Transactional
	public CompanyItemResponse update(CompanyItemUpdateRequest request) {
		checkEntityExists(request.getId());

		var updateMerger = context.getBean(CompanyItemMerger.class);
		var responseMapper = context.getBean(CompanyItemResponseMapper.class);

		var entity = updateMerger.merge(repository.getOne(request.getId()), request);

		entity = repository.saveAndFlush(entity);

		return responseMapper.from(entity);
	}

	@Override
	@Transactional
	public void delete(CompanyItemDeleteRequest request) {
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
