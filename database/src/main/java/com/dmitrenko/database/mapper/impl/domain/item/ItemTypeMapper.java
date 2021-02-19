package com.dmitrenko.database.mapper.impl.domain.item;

import com.dmitrenko.database.dto.request.item.ItemTypeRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemTypeMapper implements Mapper<ItemType, ItemTypeRequest> {

	@Override
	public ItemType from(ItemTypeRequest source) {
		return new ItemType()
			.setName(source.getName())
			.setDescription(source.getDescription());
	}
}
