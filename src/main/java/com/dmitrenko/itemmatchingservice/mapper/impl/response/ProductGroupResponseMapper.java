package com.dmitrenko.itemmatchingservice.mapper.impl.response;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.response.ProductGroupResponse;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGroupResponseMapper implements Mapper<ProductGroupResponse, ProductGroup> {

	@Override
	public ProductGroupResponse from(ProductGroup source) {
		return new ProductGroupResponse()
			.setProductId(source.getGroupId())
			.setName(source.getName());
	}
}
