package com.dmitrenko.itemmatchingservice.mapper.impl.engine;

import com.dmitrenko.itemmatchingservice.dto.request.engine.CompetitorItem;
import com.dmitrenko.itemmatchingservice.dto.view.ComparedItemView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComparedItemsViewMapper implements Mapper<ComparedItemView, CompetitorItem> {

	@Override
	public ComparedItemView from(CompetitorItem source) {
		return new ComparedItemView()
			.setName(source.getName() == null ? null : source.getName())
			.setBarcode(source.getBarcode() == null ? null : source.getBarcode());
	}
}
