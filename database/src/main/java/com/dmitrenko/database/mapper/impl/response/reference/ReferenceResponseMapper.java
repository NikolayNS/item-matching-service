package com.dmitrenko.database.mapper.impl.response.reference;

import com.dmitrenko.database.domain.reference.Reference;
import com.dmitrenko.database.dto.response.reference.ReferenceResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceResponseMapper implements Mapper<ReferenceResponse, Reference> {

	@Override
	public ReferenceResponse from(Reference source) {
		return new ReferenceResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setCreated(source.getCreatedDateTime())
			.setCreated(source.getModifiedDateTime());
	}
}
