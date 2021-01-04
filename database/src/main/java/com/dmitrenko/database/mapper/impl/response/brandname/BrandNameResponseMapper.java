package com.dmitrenko.database.mapper.impl.response.brandname;

import com.dmitrenko.database.domain.brandname.BrandName;
import com.dmitrenko.database.dto.response.brandname.BrandNameResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandNameResponseMapper implements Mapper<BrandNameResponse, BrandName> {

	@Override
	public BrandNameResponse from(BrandName source) {
		return new BrandNameResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
