package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.dto.request.ItemMatchingRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ItemMatchingResponse;
import com.dmitrenko.itemmatchingservice.engine.ItemMatchingEngine;
import com.dmitrenko.itemmatchingservice.mapper.impl.ComparedItemsViewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemMatchingEngineImpl implements ItemMatchingEngine {

	private final ApplicationContext context;

	@Override
	public ItemMatchingResponse findMatchingItems(ItemMatchingRequest request) {

		var comparedItemsViewMapper = context.getBean(ComparedItemsViewMapper.class);
		var comparedItemsView = comparedItemsViewMapper.from(request.getCompetitorItems());

		return null;
	}
}
