package com.dmitrenko.database.mapper.impl.response.item;

import com.dmitrenko.database.domain.item.Item;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.mapper.Mapper;
import com.dmitrenko.database.mapper.impl.response.brandname.BrandNameResponseMapper;
import com.dmitrenko.database.mapper.impl.response.company.CompanyResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemResponseMapper implements Mapper<ItemResponse, Item> {

	private final PriceResponseMapper priceResponseMapper;
	private final CompanyResponseMapper companyResponseMapper;
	private final BrandNameResponseMapper brandNameResponseMapper;

	@Override
	public ItemResponse from(Item source) {
		return new ItemResponse()
			.setId(source.getId())
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setPrice(priceResponseMapper.from(source.getPrice()))
			.setCompany(companyResponseMapper.from(source.getCompany()))
			.setBrandName(brandNameResponseMapper.from(source.getBrandName()))
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
