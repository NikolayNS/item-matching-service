package com.dmitrenko.database.mapper.impl.response.item;

import com.dmitrenko.database.domain.item.Item;
import com.dmitrenko.database.domain.item.ItemModifiedString;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.mapper.Mapper;
import com.dmitrenko.database.mapper.impl.response.company.CompanyResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemResponseMapper implements Mapper<ItemResponse, Item> {

	private final PriceResponseMapper priceResponseMapper;
	private final ItemTypeResponseMapper itemTypeResponseMapper;
	private final ModifiedStringResponseMapper modifiedStringResponseMapper;
	private final CompanyResponseMapper companyResponseMapper;
	private final BrandNameResponseMapper brandNameResponseMapper;

	@Override
	public ItemResponse from(Item source) {
		return new ItemResponse()
			.setId(source.getId())
			.setBarcode(source.getBarcode())
			.setOriginalName(source.getOriginalName())
			.setModifiedName(source.getModifiedName())
			.setPrice(priceResponseMapper.from(source.getPrice()))
			.setType(itemTypeResponseMapper.from(source.getType()))
			.setCompany(companyResponseMapper.from(source.getCompany()))
			.setBrandName(brandNameResponseMapper.from(source.getBrandName()))
			.setModifiedStrings(modifiedStringResponseMapper.from(source.getItemModifiedStrings()
				.stream()
				.map(ItemModifiedString::getModifiedString)
				.collect(Collectors.toList())))
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
