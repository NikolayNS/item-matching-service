package com.dmitrenko.itemmatchingservice.mapper.impl;

import com.dmitrenko.itemmatchingservice.dto.request.CompetitorItem;
import com.dmitrenko.itemmatchingservice.dto.view.ComparedItemsView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComparedItemsViewMapper implements Mapper<ComparedItemsView, CompetitorItem> {

	@Override
	public ComparedItemsView from(CompetitorItem source) {
		return null;
	}
}
