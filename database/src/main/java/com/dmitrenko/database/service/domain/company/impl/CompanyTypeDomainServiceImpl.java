package com.dmitrenko.database.service.domain.company.impl;

import com.dmitrenko.database.domain.company.CompanyType;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.company.CompanyTypeMapper;
import com.dmitrenko.database.mapper.impl.domain.company.CompanyTypeMerger;
import com.dmitrenko.database.mapper.impl.response.company.CompanyTypeResponseMapper;
import com.dmitrenko.database.repository.CompanyTypeRepository;
import com.dmitrenko.database.service.domain.company.CompanyTypeDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyTypeDomainServiceImpl implements CompanyTypeDomainService {

	private final CompanyTypeRepository companyTypeRepository;

	private final CompanyTypeMapper companyTypeMapper;
	private final CompanyTypeMerger companyTypeMerger;
	private final CompanyTypeResponseMapper companyTypeResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CompanyTypeResponse addCompanyType(@Valid CompanyTypeRequest request) {
		checkEntityNotExist(request.getName());

		var type = companyTypeMapper.from(request);
		type = companyTypeRepository.saveAndFlush(type);

		return companyTypeResponseMapper.from(type);
	}

	private void checkEntityNotExist(String name) {
		if (companyTypeRepository.findByName(name).isPresent())
			throw new EntityAlreadyExistException(String.format("Company type with name %s already exist", name));
	}

	@Override
	@Transactional(readOnly = true)
	public CompanyTypeResponse getCompanyType(Long typeId) {
		return companyTypeResponseMapper.from(getEntity(typeId));
	}

	private CompanyType getEntity(Long id) {
		return companyTypeRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Company type with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompanyTypeResponse> getAllCompanyTypes() {
		return companyTypeResponseMapper.from(companyTypeRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CompanyTypeResponse updateCompanyType(Long typeId, @Valid CompanyTypeRequest request) {
		var type = getEntity(typeId);
		type = companyTypeMerger.merge(type, request);

		type = companyTypeRepository.saveAndFlush(type);

		return companyTypeResponseMapper.from(type);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteCompanyType(Long companyId) {
		var type = getEntity(companyId);
		companyTypeRepository.delete(type);
	}
}
