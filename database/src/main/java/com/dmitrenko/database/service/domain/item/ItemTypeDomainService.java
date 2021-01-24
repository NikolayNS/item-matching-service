package com.dmitrenko.database.service.domain.item;

import com.dmitrenko.database.dto.request.item.ItemTypeRequest;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;

import java.util.List;

public interface ItemTypeDomainService {

	ItemTypeResponse addItemType(ItemTypeRequest request);

	ItemTypeResponse getItemType(Long typeId);

	List<ItemTypeResponse> getAllItemTypes();

	ItemTypeResponse updateItemType(Long typeId, ItemTypeRequest request);

	boolean deleteItemType(Long typeId);
}
