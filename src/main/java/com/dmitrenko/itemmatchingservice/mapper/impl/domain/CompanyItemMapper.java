package com.dmitrenko.itemmatchingservice.mapper.impl.domain;

import com.dmitrenko.itemmatchingservice.domain.CompanyItem;
import com.dmitrenko.itemmatchingservice.dto.request.add.CompanyItemAddRequest;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import com.dmitrenko.itemmatchingservice.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyItemMapper implements Mapper<CompanyItem, CompanyItemAddRequest> {

	private final ProductGroupService productGroupService;

	@Override
	public CompanyItem from(CompanyItemAddRequest source) {
		return new CompanyItem()
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setProductGroup(productGroupService.getById(source.getProductGroupId()));
	}
}
