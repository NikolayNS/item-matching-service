package com.dmitrenko.database.mapper.impl.response.company;

import com.dmitrenko.database.domain.company.Company;
import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyResponseMapper implements Mapper<CompanyResponse, Company> {

	private final CompanyTypeResponseMapper companyTypeResponseMapper;

	@Override
	public CompanyResponse from(Company source) {
		return new CompanyResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setType(companyTypeResponseMapper.from(source.getType()))
			.setCreated(source.getCreatedDateTime())
			.setCreated(source.getModifiedDateTime());
	}
}
