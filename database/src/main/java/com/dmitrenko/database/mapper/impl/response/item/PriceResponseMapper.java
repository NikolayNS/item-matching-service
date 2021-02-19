package com.dmitrenko.database.mapper.impl.response.item;

import com.dmitrenko.database.domain.item.Price;
import com.dmitrenko.database.dto.response.item.PriceResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceResponseMapper implements Mapper<PriceResponse, Price> {

	@Override
	public PriceResponse from(Price source) {
		return new PriceResponse()
			.setId(source.getId())
			.setCost(source.getCost().toString())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
