package com.dmitrenko.database.mapper.impl.domain.brandname;

import com.dmitrenko.database.domain.brandname.BrandName;
import com.dmitrenko.database.dto.request.brandname.BrandNameRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandNameMerger implements Merger<BrandName, BrandNameRequest> {

	@Override
	public BrandName merge(BrandName target, BrandNameRequest source) {
		return target
			.setName(source.getName());
	}
}
