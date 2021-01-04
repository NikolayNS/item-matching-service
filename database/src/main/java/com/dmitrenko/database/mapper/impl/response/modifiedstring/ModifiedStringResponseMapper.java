package com.dmitrenko.database.mapper.impl.response.modifiedstring;

import com.dmitrenko.database.domain.modifedstring.ModifiedString;
import com.dmitrenko.database.dto.response.modifiedstring.ModifiedStringResponse;
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
