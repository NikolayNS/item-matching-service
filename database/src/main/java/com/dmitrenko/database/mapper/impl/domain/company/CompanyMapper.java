package com.dmitrenko.database.mapper.impl.domain.company;

import com.dmitrenko.database.domain.company.Company;
import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyMapper implements Mapper<Company, CompanyRequest> {

	@Override
	public Company from(CompanyRequest source) {
		return new Company()
			.setName(source.getName());
	}
}
