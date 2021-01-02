package com.dmitrenko.database.mapper.impl.response.company;

import com.dmitrenko.database.domain.company.CompanyType;
import com.dmitrenko.database.dto.response.company.CompanyTypeResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyTypeResponseMapper implements Mapper<CompanyTypeResponse, CompanyType> {

	@Override
	public CompanyTypeResponse from(CompanyType source) {
		return new CompanyTypeResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setDescription(source.getDescription())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
