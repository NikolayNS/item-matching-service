package com.dmitrenko.database.mapper.impl.domain.company;

import com.dmitrenko.database.domain.company.CompanyType;
import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyTypeMapper implements Mapper<CompanyType, CompanyTypeRequest> {

	@Override
	public CompanyType from(CompanyTypeRequest source) {
		return new CompanyType()
			.setName(source.getName())
			.setDescription(source.getDescription());
	}
}
