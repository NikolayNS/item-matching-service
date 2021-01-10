package com.dmitrenko.database.service.domain.brandname.impl;

import com.dmitrenko.database.domain.brandname.BrandName;
import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.dto.request.brandname.BrandNamesRequest;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.brandname.BrandNameMapper;
import com.dmitrenko.database.mapper.impl.domain.brandname.BrandNameMerger;
import com.dmitrenko.database.mapper.impl.response.brandname.BrandNameResponseMapper;
import com.dmitrenko.database.repository.BrandNameRepository;
import com.dmitrenko.database.service.domain.brandname.BrandNameDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandNameDomainServiceImpl implements BrandNameDomainService {

	private final BrandNameRepository brandNameRepository;

	private final BrandNameMapper brandNameMapper;
	private final BrandNameMerger brandNameMerger;
	private final BrandNameResponseMapper brandNameResponseMapper;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public BrandNameResponse addBrandName(@Valid BrandNameRequest request) {
		checkEntityNotExist(request.getName());

		var brandName = brandNameMapper.from(request);
		brandName = brandNameRepository.saveAndFlush(brandName);

		return brandNameResponseMapper.from(brandName);
	}

	private void checkEntityNotExist(String name) {
		if (brandNameRepository.findByName(name).isPresent())
			throw new EntityAlreadyExistException(String.format("BrandName with name %s already exist", name));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<BrandNameResponse> addBrandNames(@Valid BrandNamesRequest request) {
		var checkedList = request.getBrandNames()
			.stream()
			.filter(brandNameRequest -> brandNameRepository.findByName(brandNameRequest.getName()).isEmpty())
			.collect(Collectors.toList());

		var entities = brandNameMapper.from(checkedList);
		entities = brandNameRepository.saveAll(entities);
		brandNameRepository.flush();

		return brandNameResponseMapper.from(entities);
	}

	@Override
	@Transactional(readOnly = true)
	public BrandNameResponse getBrandName(Long brandNameId) {
		return brandNameResponseMapper.from(getEntity(brandNameId));
	}

	private BrandName getEntity(Long id) {
		return brandNameRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("BrandName with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<BrandNameResponse> getAllBrandNames() {
		return brandNameResponseMapper.from(brandNameRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BrandNameResponse updateBrandName(Long brandNameId, @Valid BrandNameRequest request) {
		var brandName = getEntity(brandNameId);
		brandName = brandNameMerger.merge(brandName, request);

		brandName = brandNameRepository.saveAndFlush(brandName);

		return brandNameResponseMapper.from(brandName);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBrandName(Long brandNameId) {
		var brandName = getEntity(brandNameId);
		brandNameRepository.delete(brandName);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteAllBrandNames() {
		brandNameRepository.deleteAll();
	}
}
