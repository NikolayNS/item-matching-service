package com.dmitrenko.database.service.domain.company.impl;

import com.dmitrenko.database.domain.company.Company;
import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.company.CompanyMapper;
import com.dmitrenko.database.mapper.impl.domain.company.CompanyMerger;
import com.dmitrenko.database.mapper.impl.response.company.CompanyResponseMapper;
import com.dmitrenko.database.repository.CompanyRepository;
import com.dmitrenko.database.service.domain.company.CompanyDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyDomainServiceImpl implements CompanyDomainService {

	private final CompanyRepository companyRepository;

	private final CompanyMapper companyMapper;
	private final CompanyMerger companyMerger;
	private final CompanyResponseMapper companyResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CompanyResponse addCompany(@Valid CompanyRequest request) {
		if (companyRepository.findByName(request.getName()).isPresent())
			throw new EntityAlreadyExistException(String.format("Company with name %s already exist", request.getName()));

		var company = companyMapper.from(request);
		company = companyRepository.saveAndFlush(company);

		return companyResponseMapper.from(company);
	}

	@Override
	@Transactional(readOnly = true)
	public CompanyResponse getCompany(Long companyId) {
		return companyResponseMapper.from(getEntity(companyId));
	}

	private Company getEntity(Long id) {
		return companyRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("Company with id %s not found", id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompanyResponse> getAllCompanies() {
		return companyResponseMapper.from(companyRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CompanyResponse updateCompany(Long companyId, @Valid CompanyRequest request) {
		var company = getEntity(companyId);
		company = companyMerger.merge(company, request);

		company = companyRepository.saveAndFlush(company);

		return companyResponseMapper.from(company);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteCompany(Long companyId) {
		companyRepository.delete(getEntity(companyId));
		return !companyRepository.existsById(companyId);
	}
}
