package com.dmitrenko.privateapi.service.impl;

import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.item.ItemsUpdateRequest;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.service.domain.item.ItemDomainService;
import com.dmitrenko.privateapi.service.ItemService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final ItemDomainService itemDomainService;

	@Override
	public ObjectResponse<ItemResponse> addItem(ItemRequest request) {
		return ObjectResponse.success(itemDomainService.addItem(request));
	}

	@Override
	public ListResponse<ItemResponse> addItems(ItemsAddRequest request) {
		return ListResponse.success(itemDomainService.addItems(request));
	}

	@Override
	public ObjectResponse<ItemResponse> getItem(Long itemId) {
		return ObjectResponse.success(itemDomainService.getItem(itemId));
	}

	@Override
	public ListResponse<ItemResponse> getAllItemsByCompany(Long companyId) {
		return ListResponse.success(itemDomainService.getAllItemsByCompany(companyId));
	}

	@Override
	public ObjectResponse<ItemResponse> updateItem(Long itemId, ItemRequest request) {
		return ObjectResponse.success(itemDomainService.updateItem(itemId, request));
	}

	@Override
	public ListResponse<ItemResponse> updateItems(ItemsUpdateRequest request) {
		return ListResponse.success(itemDomainService.updateItems(request));
	}

	@Override
	public SuccessWrapper deleteItem(Long itemId) {
		return new SuccessWrapper(itemDomainService.deleteItem(itemId));
	}

	@Override
	public SuccessWrapper deleteAllItemsByCompany(Long companyId) {
		return new SuccessWrapper(itemDomainService.deleteAllItemsByCompany(companyId));
	}
}
