package com.dmitrenko.itemmatchingservice.mapper.impl.domain;

import com.dmitrenko.itemmatchingservice.domain.CompanyItem;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyItemMapper implements Mapper<CompanyItem, CompanyItemAddRequest> {

	@Override
	public CompanyItem from(CompanyItemAddRequest source) {
		return new CompanyItem()
			.setBarcode(source.getBarcode())
			.setName(source.getName());
	}
}
