package com.dmitrenko.itemmatchingservice.mapper.impl.update;

import com.dmitrenko.itemmatchingservice.domain.ProductGroup;
import com.dmitrenko.itemmatchingservice.dto.request.update.ProductGroupUpdateRequest;
import com.dmitrenko.itemmatchingservice.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGroupMerger implements Merger<ProductGroup, ProductGroupUpdateRequest> {

	@Override
	public ProductGroup merge(ProductGroup target, ProductGroupUpdateRequest source) {
		return target
			.setGroupIndex(source.getGroupIndex())
			.setName(source.getName());
	}
}
