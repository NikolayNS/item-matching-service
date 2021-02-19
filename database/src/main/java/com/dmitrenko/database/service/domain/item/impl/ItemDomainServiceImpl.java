package com.dmitrenko.database.service.domain.item.impl;

import com.dmitrenko.database.domain.item.Item;
import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.item.ItemsUpdateRequest;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.repository.ItemRepository;
import com.dmitrenko.database.service.domain.item.ItemDomainService;
import com.dmitrenko.database.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemDomainServiceImpl implements ItemDomainService {

	private final ItemRepository itemRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ItemResponse addItem(@Valid ItemRequest request) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ItemResponse> addItems(@Valid ItemsAddRequest request) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ItemResponse getItem(Long itemId) {
		return null;
	}

	private Item getEntity(Long id) {
		return itemRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format(Constant.ITEM_NOT_FOUND, id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ItemResponse> getAllItemsByCompany(Long companyId) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ItemResponse updateItem(Long itemId, @Valid ItemRequest request) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<ItemResponse> updateItems(@Valid ItemsUpdateRequest request) {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteItem(Long itemId) {
		return false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteAllItemsByCompany(Long companyId) {
		return false;
	}
}
