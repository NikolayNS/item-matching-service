package com.dmitrenko.database.mapper.impl.domain.reference;

import com.dmitrenko.database.domain.reference.Reference;
import com.dmitrenko.database.dto.request.reference.ReferenceRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceMapper implements Mapper<Reference, ReferenceRequest> {

	@Override
	public Reference from(ReferenceRequest source) {
		return new Reference()
			.setName(source.getName());
	}
}
