package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.item.ItemsUpdateRequest;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface ItemService {

	ObjectResponse<ItemResponse> addItem(ItemRequest request);

	ListResponse<ItemResponse> addItems(ItemsAddRequest request);

	ObjectResponse<ItemResponse> getItem(Long itemId);

	ListResponse<ItemResponse> getAllItemsByCompany(Long companyId);

	ObjectResponse<ItemResponse> updateItem(Long itemId, ItemRequest request);

	ListResponse<ItemResponse> updateItems(ItemsUpdateRequest request);

	SuccessWrapper deleteItem(Long itemId);

	SuccessWrapper deleteAllItemsByCompany(Long companyId);

	ObjectResponse<ItemTypeResponse> addItemType(ItemTypeRequest request);

	ObjectResponse<ItemTypeResponse> getItemType(Long typeId);

	ListResponse<ItemTypeResponse> getAllItemTypes();

	ObjectResponse<ItemTypeResponse> updateItemType(Long typeId, ItemTypeRequest request);

	SuccessWrapper deleteItemType(Long typeId);
}
