package com.dmitrenko.itemmatchingservice.mapper.impl.update;

import com.dmitrenko.itemmatchingservice.domain.CompanyItem;
import com.dmitrenko.itemmatchingservice.dto.request.companyitem.CompanyItemUpdateRequest;
import com.dmitrenko.itemmatchingservice.mapper.Merger;
import com.dmitrenko.itemmatchingservice.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyItemMerger implements Merger<CompanyItem, CompanyItemUpdateRequest> {

	private final ProductGroupService productGroupService;

	@Override
	public CompanyItem merge(CompanyItem target, CompanyItemUpdateRequest source) {
		return target
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setProductGroup(productGroupService.getById(source.getProductGroupId()));
	}
}
