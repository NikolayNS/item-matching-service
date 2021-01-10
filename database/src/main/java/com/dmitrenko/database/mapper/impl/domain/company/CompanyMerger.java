package com.dmitrenko.database.mapper.impl.domain.company;

import com.dmitrenko.database.domain.company.Company;
import com.dmitrenko.database.domain.company.CompanyType;
import com.dmitrenko.database.dto.request.company.CompanyRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyMerger implements Merger<Company, CompanyRequest> {

	@Override
	public Company merge(Company target, CompanyRequest source) {
		return target
			.setName(source.getName())
			.setType(new CompanyType(source.getTypeId()));
	}
}
