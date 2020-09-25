package com.dmitrenko.itemmatchingservice.mapper.impl.view;

import com.dmitrenko.itemmatchingservice.dto.request.engine.CompetitorItemRequest;
import com.dmitrenko.itemmatchingservice.dto.view.CompetitorItemView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetitorItemsViewMapper implements Mapper<CompetitorItemView, CompetitorItemRequest> {

	private final ApplicationContext context;

	@Override
	public CompetitorItemView from(CompetitorItemRequest source) {
		var ngramViewMapper = context.getBean(NgramViewMapper.class);
		return new CompetitorItemView()
			.setName(source.getName() == null ? null : source.getName())
			.setBarcode(source.getBarcode() == null ? null : source.getBarcode())
			.setNgrams(ngramViewMapper.from(source.getName() == null ? null : source.getName()));
	}
}
