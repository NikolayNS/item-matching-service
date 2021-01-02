package com.dmitrenko.database.mapper.impl.response.reference;

import com.dmitrenko.database.domain.reference.ReferenceField;
import com.dmitrenko.database.dto.response.reference.ReferenceFieldResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceFieldResponseMapper implements Mapper<ReferenceFieldResponse, ReferenceField> {

	private final ReferenceResponseMapper referenceResponseMapper;

	@Override
	public ReferenceFieldResponse from(ReferenceField source) {
		return new ReferenceFieldResponse()
			.setId(source.getId())
			.setBarcode(source.getBarcode())
			.setName(source.getName())
			.setReference(referenceResponseMapper.from(source.getReference()))
			.setCreated(source.getCreatedDateTime())
			.setModified(source.getModifiedDateTime());
	}
}
