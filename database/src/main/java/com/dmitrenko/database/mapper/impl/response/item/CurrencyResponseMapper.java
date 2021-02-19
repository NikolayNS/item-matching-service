package com.dmitrenko.database.mapper.impl.response.item;

import com.dmitrenko.database.dto.response.item.CurrencyResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyResponseMapper implements Mapper<CurrencyResponse, Currency> {

	@Override
	public CurrencyResponse from(Currency source) {
		return new CurrencyResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setDescription(source.getDescription())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
