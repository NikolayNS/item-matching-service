package com.dmitrenko.database.service.domain.item;

import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.item.ItemsUpdateRequest;
import com.dmitrenko.database.dto.response.item.ItemResponse;

import java.util.List;

public interface ItemDomainService {

	ItemResponse addItem(ItemRequest request);

	List<ItemResponse> addItems(ItemsAddRequest request);

	ItemResponse getItem(Long itemId);

	List<ItemResponse> getAllItemsByCompany(Long companyId);

	ItemResponse updateItem(Long itemId, ItemRequest request);

	List<ItemResponse> updateItems(ItemsUpdateRequest request);

	boolean deleteItem(Long itemId);

	boolean deleteAllItemsByCompany(Long companyId);
}
