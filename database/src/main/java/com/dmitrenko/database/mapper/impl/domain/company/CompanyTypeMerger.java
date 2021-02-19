package com.dmitrenko.database.mapper.impl.domain.company;

import com.dmitrenko.database.dto.request.company.CompanyTypeRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyTypeMerger implements Merger<CompanyType, CompanyTypeRequest> {

	@Override
	public CompanyType merge(CompanyType target, CompanyTypeRequest source) {
		return target
			.setName(source.getName())
			.setDescription(source.getDescription());
	}
}
