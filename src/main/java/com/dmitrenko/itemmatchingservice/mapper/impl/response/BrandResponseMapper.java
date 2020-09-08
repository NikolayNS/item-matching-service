package com.dmitrenko.itemmatchingservice.mapper.impl.response;

import com.dmitrenko.itemmatchingservice.domain.Brand;
import com.dmitrenko.itemmatchingservice.dto.response.BrandResponse;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandResponseMapper implements Mapper<BrandResponse, Brand> {

	@Override
	public BrandResponse from(Brand source) {
		return new BrandResponse()
			.setName(source.getName());
	}
}
