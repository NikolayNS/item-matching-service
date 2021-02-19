package com.dmitrenko.database.mapper.impl.domain.item;

import com.dmitrenko.database.dto.request.item.ItemTypeRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemTypeMerger implements Merger<ItemType, ItemTypeRequest> {

	@Override
	public ItemType merge(ItemType target, ItemTypeRequest source) {
		return target
			.setName(source.getName())
			.setDescription(source.getDescription());
	}
}
