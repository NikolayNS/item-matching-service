package com.dmitrenko.database.mapper.impl.response.item;

import com.dmitrenko.database.domain.item.ItemType;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemTypeResponseMapper implements Mapper<ItemTypeResponse, ItemType> {

	@Override
	public ItemTypeResponse from(ItemType source) {
		return new ItemTypeResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setDescription(source.getDescription())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
