package com.dmitrenko.itemmatchingservice.mapper.impl.domain;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.request.productgroup.ProductGroupAddRequest;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGroupMapper implements Mapper<ProductGroup, ProductGroupAddRequest> {

	@Override
	public ProductGroup from(ProductGroupAddRequest source) {
		return new ProductGroup()
			.setGroupIndex(source.getGroupIndex())
			.setName(source.getName());
	}
}
