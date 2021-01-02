package com.dmitrenko.database.mapper.impl.response.item;

import com.dmitrenko.database.domain.item.ModifiedString;
import com.dmitrenko.database.dto.response.item.ModifiedStringResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifiedStringResponseMapper implements Mapper<ModifiedStringResponse, ModifiedString> {

	@Override
	public ModifiedStringResponse from(ModifiedString source) {
		return new ModifiedStringResponse()
			.setId(source.getId())
			.setModifiable(source.getModifiable())
			.setModifying(source.getModifying())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
