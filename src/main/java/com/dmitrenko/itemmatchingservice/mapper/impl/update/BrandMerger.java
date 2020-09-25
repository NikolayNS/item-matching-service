package com.dmitrenko.itemmatchingservice.mapper.impl.update;

import com.dmitrenko.itemmatchingservice.domain.Brand;
import com.dmitrenko.itemmatchingservice.dto.request.brand.BrandUpdateRequest;
import com.dmitrenko.itemmatchingservice.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandMerger implements Merger<Brand, BrandUpdateRequest> {

	@Override
	public Brand merge(Brand target, BrandUpdateRequest source) {
		return target
			.setName(source.getName());
	}
}
