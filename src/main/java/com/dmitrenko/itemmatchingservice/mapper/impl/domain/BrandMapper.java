package com.dmitrenko.itemmatchingservice.mapper.impl.domain;

import com.dmitrenko.itemmatchingservice.domain.Brand;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandAddRequest;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandMapper implements Mapper<Brand, BrandAddRequest> {

	@Override
	public Brand from(BrandAddRequest source) {
		return new Brand()
			.setName(source.getName());
	}
}
