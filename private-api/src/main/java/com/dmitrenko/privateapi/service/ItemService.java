package com.dmitrenko.privateapi.service;

import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.item.ItemsUpdateRequest;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;

public interface ItemService {

	ObjectResponse<ItemResponse> addItem(ItemRequest request);

	ListResponse<ItemResponse> addItems(ItemsAddRequest request);

	ObjectResponse<ItemResponse> getItem(Long itemId);

	ListResponse<ItemResponse> getAllItemsByCompany(Long companyId);

	ObjectResponse<ItemResponse> updateItem(Long itemId, ItemRequest request);

	ListResponse<ItemResponse> updateItems(ItemsUpdateRequest request);

	SuccessWrapper deleteItem(Long itemId);

	SuccessWrapper deleteAllItemsByCompany(Long companyId);
}
