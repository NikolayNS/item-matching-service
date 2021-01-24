package com.dmitrenko.database.mapper.impl.domain.item;

import com.dmitrenko.database.domain.item.Item;
import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMapper implements Mapper<Item, ItemRequest> {

	@Override
	public Item from(ItemRequest source) {
		return null;
	}
}
