package com.dmitrenko.database.mapper.impl.response.reference;

import com.dmitrenko.database.dto.response.reference.ReferenceTypeResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceTypeResponseMapper implements Mapper<ReferenceTypeResponse, ReferenceType> {

	@Override
	public ReferenceTypeResponse from(ReferenceType source) {
		return new ReferenceTypeResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setDescription(source.getDescription())
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
