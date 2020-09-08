package com.dmitrenko.itemmatchingservice.mapper.impl.response;

import com.dmitrenko.itemmatchingservice.domain.CompanyItem;
import com.dmitrenko.itemmatchingservice.dto.response.CompanyItemResponse;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyItemResponseMapper implements Mapper<CompanyItemResponse, CompanyItem> {

	private final ApplicationContext context;

	@Override
	public CompanyItemResponse from(CompanyItem source) {
		var productGroupResponseMapper = context.getBean(ProductGroupResponseMapper.class);

		return new CompanyItemResponse()
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setProductGroup(productGroupResponseMapper.from(source.getProductGroup()));
	}
}
