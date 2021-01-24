package com.dmitrenko.database.service.domain.item.impl;

import com.dmitrenko.database.domain.item.ItemType;
import com.dmitrenko.database.dto.request.item.ItemTypeRequest;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.item.ItemTypeMapper;
import com.dmitrenko.database.mapper.impl.domain.item.ItemTypeMerger;
import com.dmitrenko.database.mapper.impl.response.item.ItemTypeResponseMapper;
import com.dmitrenko.database.repository.ItemTypeRepository;
import com.dmitrenko.database.service.domain.item.ItemTypeDomainService;
import com.dmitrenko.database.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemTypeDomainServiceImpl implements ItemTypeDomainService {

	private final ItemTypeRepository itemTypeRepository;

	private final ItemTypeMapper itemTypeMapper;
	private final ItemTypeMerger itemTypeMerger;
	private final ItemTypeResponseMapper itemTypeResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ItemTypeResponse addItemType(@Valid ItemTypeRequest request) {
		if (itemTypeRepository.findByName(request.getName()).isPresent())
			throw new EntityAlreadyExistException(String.format(Constant.ITEM_TYPE_ALREADY_EXIST, request.getName()));

		var type = itemTypeMapper.from(request);
		type = itemTypeRepository.saveAndFlush(type);

		return itemTypeResponseMapper.from(type);
	}

	@Override
	@Transactional(readOnly = true)
	public ItemTypeResponse getItemType(Long typeId) {
		return itemTypeResponseMapper.from(getEntity(typeId));
	}

	private ItemType getEntity(Long id) {
		return itemTypeRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format(Constant.ITEM_TYPE_NOT_FOUND, id)));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ItemTypeResponse> getAllItemTypes() {
		return itemTypeResponseMapper.from(itemTypeRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ItemTypeResponse updateItemType(Long typeId, @Valid ItemTypeRequest request) {
		var type = getEntity(typeId);

		type = itemTypeMerger.merge(type, request);
		type = itemTypeRepository.saveAndFlush(type);

		return itemTypeResponseMapper.from(type);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteItemType(Long typeId) {
		itemTypeRepository.delete(getEntity(typeId));

		return !itemTypeRepository.existsById(typeId);
	}
}
