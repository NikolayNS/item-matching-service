package com.dmitrenko.database.mapper.impl.domain.brandname;

import com.dmitrenko.database.domain.brandname.BrandName;
import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandNameMapper implements Mapper<BrandName, BrandNameRequest> {

	@Override
	public BrandName from(BrandNameRequest source) {
		return new BrandName()
			.setName(source.getName());
	}
}
