package com.dmitrenko.database.mapper.impl.domain.reference;

import com.dmitrenko.database.domain.reference.ReferenceType;
import com.dmitrenko.database.dto.request.reference.ReferenceTypeRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceTypeMapper implements Mapper<ReferenceType, ReferenceTypeRequest> {

	@Override
	public ReferenceType from(ReferenceTypeRequest source) {
		return new ReferenceType()
			.setName(source.getName())
			.setDescription(source.getDescription());
	}
}
