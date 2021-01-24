package com.dmitrenko.database.mapper.impl.domain.item;

import com.dmitrenko.database.domain.item.Item;
import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMerger implements Merger<Item, ItemRequest> {

	@Override
	public Item merge(Item target, ItemRequest source) {
		return null;
	}
}
